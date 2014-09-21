__author__ = 'Anthony'
import os
from subprocess import Popen, PIPE
from itertools import combinations
print os.getcwd()
os.chdir("../bin")
print os.getcwd()
# Tpdahp
plate_dimens = [10 * i for i in range(1,3)]
initial_heats = [10 * i for i in range(1,3)]
simulations = ["Tpdahp", "Twdahp", "Tpdohp", "Tpfahp", "Twfahp"]
test_results = {}
header = "Sim Type, Top Heat, Dimension, iterations, time (ms), memory usage (bytes)"
print "running tests"
print header


def parse_output(output):
    simtype, iter_str, ms_str, mem_str = output.split(",")
    iter = int(iter_str)
    ms = int(ms_str)
    mem = int(mem_str)
    if (simtype, initial_heat, plate_dimen) not in test_results:
        test_results[(simtype, initial_heat, plate_dimen)] = []
    test_results[(simtype, initial_heat, plate_dimen)].append([iter, ms, mem])
    print "{}, {}, {}, {}, {}, {}".format(simtype, initial_heat, plate_dimen, iter, ms, mem)


for i in xrange(2):
    for initial_heat in initial_heats:
        for plate_dimen in plate_dimens:
            for simulation in simulations:
                process = Popen(["java", "{}.Demo".format(simulation), "-d", str(plate_dimen),
                                 "-t", str(initial_heat), "-b", "0", "-l", "0", "-r", "0"], stdout=PIPE)
                (output, err) = process.communicate()
                exit_code = process.wait()  # we need to wait for each one to finish so that we don't overload the system
                parse_output(output)

simulations = range(5)
for i in xrange(2):
    for initial_heat in initial_heats:
        for plate_dimen in plate_dimens:
            for simulation in simulations:
                process = Popen(["java", "Gallhp.Demo", str(plate_dimen), str(initial_heat), "0", "0", "0", str(simulation)], stdout=PIPE)
                (output, err) = process.communicate()
                exit_code = process.wait()  # we need to wait for each one to finish so that we don't overload the system
                parse_output(output)

print "-----------final averages------------------"
print "Sim_Type, Top Heat, Dimension, iterations, time (ms), memory usage (bytes)"
for simtype, test_collection in test_results.iteritems():
    sim_name, initial_heat, plate_dimen = simtype  # unpack
    iter_avg = sum([tup[0] for tup in test_collection])
    ms_avg = sum([tup[1] for tup in test_collection])
    mem_avg = sum([tup[2] for tup in test_collection])
    print("{}, {}, {}, {}, {}, {}".format(sim_name, initial_heat, plate_dimen, iter_avg, ms_avg, mem_avg))

