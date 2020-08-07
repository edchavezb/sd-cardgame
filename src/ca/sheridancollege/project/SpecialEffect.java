package ca.sheridancollege.project;

/**
 *
 * @author Safi K
 */
public enum SpecialEffect {
    SKIP ("Skip"),
    DTWO ("Draw Two"),
    REVERSE ("Reverse");
    
    private String specialName;

    public String getSpecialName() {
        return specialName;
    }
    
    /**
	 * 
	 * @param specialName
	 */
	private SpecialEffect(String specialName) {
        this.specialName = specialName;
    }
}