package common;

/**
 * @author Anthony
 * This enum stores the different flags that can be passed to the command line
 * programs.
 */
public enum Parameter_Flags {
	/**
	 * The flag for the length of one edge of the plate
	 */
	DIMEN("-d"),
	
	/**
	 * The flag for the top edge temperature.
	 */
	TOP("-t"),

	/**
	 * The flag for the bottom edge temperature.
	 */
	BOT("-b"),

	/**
	 * The flag for the left edge temperature.
	 */
	LEFT("-l"),

	/**
	 * The flag for the right edge temperature.
	 */
	RIGHT("-r");
	
	private final String text;

    /**
     * @param text
     */
    private Parameter_Flags(String text) {
        this.text = text;
    }
    
    @Override
    public String toString() {
        return text;
    }
    
    /**
     * Takes a command line flag and returns the enum value.
     * @param flag The command line flag.
     * @return an enum value.
     */
    public static Parameter_Flags fromString(String flag) {
        if (flag != null) {
          for (Parameter_Flags b : Parameter_Flags.values()) {
            if (flag.equalsIgnoreCase(b.text)) {
              return b;
            }
          }
        }
        return null;
    }
}