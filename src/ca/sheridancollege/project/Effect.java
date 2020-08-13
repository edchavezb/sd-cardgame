package ca.sheridancollege.project;

/**
 * This enumeration models the values that special effect cards take.
 * 
 * @author Safi K
 * @author Edgar Chavez
 */
public enum Effect implements Value, Special {
    SKIP ("Skip", 2),
    TWO ("Draw Two", 2),
    REVERSE ("Reverse", 2),
    WILD ("Wild", 1),
    FOUR ("Wild Draw Four", 1);
    
    private final String valueName;
    
    // Determines the amount of copies per suit that will be created.
    private final int numSuitSets;
    
    /**
     * The default constructor for this enumeration is passed a string with the
     * name of the effect and the number of copies per suit to be created.
     * 
     * @param valueName The string with the name of the effect.
     * @param numSuitSets The number of copies per suit to be created.
     */
    private Effect(String value, int numSets) {
        this.valueName = value;
        this.numSuitSets = numSets;
    }
    
    /**
     * Retrieves the string with the name of the effect.
     * 
     * @return The string with the name of the effect.
     */
    @Override
    public String getValueName() {
        return valueName;
    }

    /**
     * Retrieves the number of copies per suit to be created.
     * 
     * @return The number of copies per suit of this effect.
     */
    @Override
    public int getNumSuitSets() {
        return numSuitSets;
    }
}