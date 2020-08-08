package ca.sheridancollege.project;

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
    private final int numSuitSets;
    
    /**
    * 
    * @param value
    */
    private Number(String value, int numSets) {
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
