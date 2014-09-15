package Gallhp;

import java.awt.Checkbox;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.Timer;

import common.Simulator_Interface;
import common.Simulator_Types;

public class Demo{

	private JFrame frame;
	private JSpinner spinner_dimen;
	private JSpinner spinner_top;
	private JSpinner spinner_bot;
	private JSpinner spinner_left;
	private JSpinner spinner_right;
	private JComboBox SimType_comboBox;
	private JSlider speed_slider;
	private JCheckBox checkBox;
	private DrawnGrid drawnGrid;
	private Timer animation_timer;
	private ActionListener play;
	private int iterations;
	JLabel iter_label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Demo window = new Demo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Demo() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 597, 367);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {184, 400};
		gridBagLayout.rowHeights = new int[]{0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0};
		gridBagLayout.rowWeights = new double[]{1.0};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		frame.getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel label = new JLabel("Dimension");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		panel.add(label, gbc_label);
		
		spinner_dimen = new JSpinner();
		spinner_dimen.setModel(new SpinnerNumberModel(15, 0, 100, 1));
		GridBagConstraints gbc_spinner_dimen = new GridBagConstraints();
		gbc_spinner_dimen.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_dimen.insets = new Insets(0, 0, 5, 0);
		gbc_spinner_dimen.gridx = 1;
		gbc_spinner_dimen.gridy = 0;
		panel.add(spinner_dimen, gbc_spinner_dimen);
		
		JLabel label_1 = new JLabel("Top");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 1;
		panel.add(label_1, gbc_label_1);
		
		spinner_top = new JSpinner();
		spinner_top.setModel(new SpinnerNumberModel(0.0, 0.0, 100.0, 1.0));
		GridBagConstraints gbc_spinner_top = new GridBagConstraints();
		gbc_spinner_top.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_top.insets = new Insets(0, 0, 5, 0);
		gbc_spinner_top.gridx = 1;
		gbc_spinner_top.gridy = 1;
		panel.add(spinner_top, gbc_spinner_top);
		
		JLabel label_2 = new JLabel("Bottom");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 2;
		panel.add(label_2, gbc_label_2);
		
		spinner_bot = new JSpinner();
		spinner_bot.setModel(new SpinnerNumberModel(0.0, 0.0, 100.0, 1.0));
		GridBagConstraints gbc_spinner_bot = new GridBagConstraints();
		gbc_spinner_bot.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_bot.insets = new Insets(0, 0, 5, 0);
		gbc_spinner_bot.gridx = 1;
		gbc_spinner_bot.gridy = 2;
		panel.add(spinner_bot, gbc_spinner_bot);
		
		JLabel label_3 = new JLabel("Left");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 3;
		panel.add(label_3, gbc_label_3);
		
		spinner_left = new JSpinner();
		spinner_left.setModel(new SpinnerNumberModel(0.0, 0.0, 100.0, 1.0));
		GridBagConstraints gbc_spinner_left = new GridBagConstraints();
		gbc_spinner_left.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_left.insets = new Insets(0, 0, 5, 0);
		gbc_spinner_left.gridx = 1;
		gbc_spinner_left.gridy = 3;
		panel.add(spinner_left, gbc_spinner_left);
		
		JLabel label_4 = new JLabel("Right");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 0;
		gbc_label_4.gridy = 4;
		panel.add(label_4, gbc_label_4);
		
		spinner_right = new JSpinner();
		spinner_right.setModel(new SpinnerNumberModel(0.0, 0.0, 100.0, 1.0));
		GridBagConstraints gbc_spinner_right = new GridBagConstraints();
		gbc_spinner_right.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_right.insets = new Insets(0, 0, 5, 0);
		gbc_spinner_right.gridx = 1;
		gbc_spinner_right.gridy = 4;
		panel.add(spinner_right, gbc_spinner_right);
		
		JLabel label_5 = new JLabel("Simulation Type");
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.anchor = GridBagConstraints.EAST;
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 0;
		gbc_label_5.gridy = 5;
		panel.add(label_5, gbc_label_5);
		
		SimType_comboBox = new JComboBox();
		SimType_comboBox.setModel(new DefaultComboBoxModel(Simulator_Types.values()));
		GridBagConstraints gbc_SimType_comboBox = new GridBagConstraints();
		gbc_SimType_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_SimType_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_SimType_comboBox.gridx = 1;
		gbc_SimType_comboBox.gridy = 5;
		panel.add(SimType_comboBox, gbc_SimType_comboBox);
		
		JLabel label_6 = new JLabel("Iteration");
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 0;
		gbc_label_6.gridy = 6;
		panel.add(label_6, gbc_label_6);
		
		iter_label = new JLabel("0");
		GridBagConstraints gbc_iter_label = new GridBagConstraints();
		gbc_iter_label.insets = new Insets(0, 0, 5, 0);
		gbc_iter_label.gridx = 1;
		gbc_iter_label.gridy = 6;
		panel.add(iter_label, gbc_iter_label);
		
		JLabel label_8 = new JLabel("Speed");
		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.insets = new Insets(0, 0, 5, 5);
		gbc_label_8.gridx = 0;
		gbc_label_8.gridy = 7;
		panel.add(label_8, gbc_label_8);
		
		speed_slider = new JSlider();
		speed_slider.setValue(80);
		GridBagConstraints gbc_speed_slider = new GridBagConstraints();
		gbc_speed_slider.fill = GridBagConstraints.HORIZONTAL;
		gbc_speed_slider.insets = new Insets(0, 0, 5, 0);
		gbc_speed_slider.gridx = 1;
		gbc_speed_slider.gridy = 7;
		panel.add(speed_slider, gbc_speed_slider);
		
		JButton button = new JButton("Play");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 0, 5);
		gbc_button.gridx = 0;
		gbc_button.gridy = 8;
		panel.add(button, gbc_button);
		
		checkBox = new JCheckBox("Loop?");
		GridBagConstraints gbc_checkBox = new GridBagConstraints();
		gbc_checkBox.gridx = 1;
		gbc_checkBox.gridy = 8;
		panel.add(checkBox, gbc_checkBox);
		
		Simulator_Types selectedItem = (Simulator_Types) SimType_comboBox.getSelectedItem();
		int dimen = 3;
		Simulator_Interface sim_interface = new Twdahp.Simulator(3, 0., 0., 0., 0.);
		drawnGrid = new DrawnGrid(0, 0, 0, 0, dimen, dimen, sim_interface);
		GridBagConstraints gbc_drawnGrid = new GridBagConstraints();
		gbc_drawnGrid.fill = GridBagConstraints.BOTH;
		gbc_drawnGrid.gridx = 1;
		gbc_drawnGrid.gridy = 0;
		frame.getContentPane().add(drawnGrid, gbc_drawnGrid);
		
		int speed_ms = (101 - speed_slider.getValue()) * 10;
		animation_timer = new Timer(speed_ms, null);
		animation_timer.addActionListener(new AnimationListener());
		animation_timer.setCoalesce(false); //if there already is a trigger in the event loop, don't trigger again.
		
		play = new PlayListener();
		button.addActionListener(play);
	}
	
	public class AnimationListener implements ActionListener {
		@Override
        public void actionPerformed(ActionEvent e) {
			boolean heating_done = !drawnGrid.simulator.heat_once(.01);
			iterations++;
			iter_label.setText(String.valueOf(iterations));
			drawnGrid.repaint();
			System.out.println("Heating Done: " + heating_done);
			if(heating_done && checkBox.isSelected())
			{
				animation_timer.stop();
				play.actionPerformed(e);
			}
			else if(heating_done) {
				animation_timer.stop();
			}
        }
	}
	
	public class PlayListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			int    dimen = (Integer) spinner_dimen.getValue();
			Double top   = (Double) spinner_top.getValue();
			Double bot   = (Double) spinner_bot.getValue();
			Double left  = (Double) spinner_left.getValue();
			Double right = (Double) spinner_right.getValue();
			
			Simulator_Types selectedItem = (Simulator_Types) SimType_comboBox.getSelectedItem();
			if(Simulator_Types.Tpdahp == selectedItem){
				Tpdahp.Simulator sim_interface = new Tpdahp.Simulator(dimen, top, bot, left, right);
				drawnGrid = new DrawnGrid(0, 0, 0, 0, dimen, dimen, sim_interface);
			}
			else if(Simulator_Types.Twdahp == selectedItem) {
				Twdahp.Simulator sim_interface = new Twdahp.Simulator(dimen, top, bot, left, right);
				drawnGrid = new DrawnGrid(0, 0, 0, 0, dimen, dimen, sim_interface);
			}
			else if(Simulator_Types.Tpfahp == selectedItem) {
				Tpfahp.Simulator sim_interface = new Tpfahp.Simulator(dimen, top.floatValue(), bot.floatValue(), left.floatValue(), right.floatValue());
				drawnGrid = new DrawnGrid(0, 0, 0, 0, dimen, dimen, sim_interface);
			}
			else if(Simulator_Types.Tpdohp == selectedItem) {
				Tpdohp.Simulator sim_interface = new Tpdohp.Simulator(dimen, top, bot, left, right);
				drawnGrid = new DrawnGrid(0, 0, 0, 0, dimen, dimen, sim_interface);
			}
			else {
				throw new UnsupportedOperationException("That simulation type is not supported yet.");
			}
			int speed_ms = (101 - speed_slider.getValue()) * 10;
			
			GridBagConstraints gbc_drawnGrid = new GridBagConstraints();
			gbc_drawnGrid.fill = GridBagConstraints.BOTH;
			gbc_drawnGrid.gridx = 1;
			gbc_drawnGrid.gridy = 0;
			frame.getContentPane().add(drawnGrid, gbc_drawnGrid);
			frame.getContentPane().validate();
			drawnGrid.repaint();
			iterations = 0;
			
			animation_timer.setDelay(speed_ms);
			animation_timer.start();
			
		}
	};
}
