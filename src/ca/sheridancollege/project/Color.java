package ca.sheridancollege.project;

public enum Color {
    RED ("Red"),
    BLUE ("Blue"),
    GREEN ("Green"),
    YELLOW ("Yellow");
    
    private String colorName;
    
    public String getColorName() {
        return colorName;
    }
    
    private Color(String color){
        this.colorName = color;
    }
}