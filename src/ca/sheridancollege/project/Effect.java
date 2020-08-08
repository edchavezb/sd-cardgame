package ca.sheridancollege.project;

/**
 *
 * @author Safi K
 */
public enum Effect implements Value, Special {
    SKIP ("Skip", 2),
    TWO ("Draw Two", 2),
    REVERSE ("Reverse", 2),
    WILD ("Wild", 1),
    FOUR ("Wild Draw Four", 1);
    
    private final String valueName;
    private final int numSuitSets;
    
    /**
     * 
     * @param specialName
     */
    private Effect(String value, int numSets) {
        this.valueName = value;
        this.numSuitSets = numSets;
    }
    
    @Override
    public String getValueName() {
        return valueName;
    }

    @Override
    public int getNumSuitSets() {
        return numSuitSets;
    }
}