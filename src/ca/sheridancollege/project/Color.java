package ca.sheridancollege.project;

public enum Color implements Suit{
    RED ("Red"),
    BLUE ("Blue"),
    GREEN ("Green"),
    YELLOW ("Yellow");
    
    private String colorName;
    
    private Color(String color){
        this.colorName = color;
    }
    
    public String getSuitName() {
        return colorName;
    }
   
}