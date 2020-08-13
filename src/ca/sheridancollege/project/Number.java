package ca.sheridancollege.project;

/**
 * This enumeration models the values that numbered cards take.
 * 
 * @author Safi K
 * @author Edgar Chavez
 */
public enum Number implements Value{
    ZERO ("Zero", 1),
    ONE ("One", 2),
    TWO ("Two", 2),
    THREE ("Three", 2),
    FOUR ("Four", 2),
    FIVE ("Five", 2),
    SIX ("Six", 2),
    SEVEN ("Seven", 2),
    EIGHT ("Eight", 2),
    NINE ("Nine", 2);

    private final String valueName;
    
    // Determines the amount of copies per suit that will be created.
    private final int numSuitSets;
    
    /**
     * The default constructor for this enumeration is passed a string with the
     * name of the number and the amount of copies per suit to be created.
     * 
     * @param valueName The string with the name of the number.
     * @param numSuitSets The number of copies per suit to be created.
     */
    private Number(String value, int numSets) {
        this.valueName = value;
        this.numSuitSets = numSets;
    }

    /**
     * Retrieves the string with the name of the number.
     * 
     * @return The string with the name of the number.
     */
    @Override
    public String getValueName() {
        return valueName;
    }

    /**
     * Retrieves the number of copies per suit to be created.
     * 
     * @return The number of copies per suit of this number.
     */
    @Override
    public int getNumSuitSets() {
        return numSuitSets;
    }
}
