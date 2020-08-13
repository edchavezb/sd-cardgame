package ca.sheridancollege.project;

public enum Color implements Suit{
    RED ("Red"),
    BLUE ("Blue"),
    GREEN ("Green"),
    YELLOW ("Yellow");
    
    private String colorName;
    
    /**
     * Default constrcutor for the color enum.
     * 
     * @param color The string value of the color.
     */
    private Color(String color){
        this.colorName = color;
    }
    
    /**
     * It retrieves the String with the name of the color.
     * 
     * @return The name of the color.
     */
    public String getSuitName() {
        return colorName;
    }
   
}