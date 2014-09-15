package common;

public enum Parameter_Flags {
	DIMEN("-d"),
	TOP("-t"),
	BOT("-b"),
	LEFT("-l"),
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
    
    public static Parameter_Flags fromString(String text) {
        if (text != null) {
          for (Parameter_Flags b : Parameter_Flags.values()) {
            if (text.equalsIgnoreCase(b.text)) {
              return b;
            }
          }
        }
        return null;
    }
}