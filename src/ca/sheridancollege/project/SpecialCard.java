package ca.sheridancollege.project;

public class SpecialCard extends Card {

    private Color color;
    private Effect effect;
    private int drawAmount = 2;
    
    /**
    * 
    * @param color
    * @param val
    */
    public SpecialCard(Value value, Suit suit) {
        super(value, suit);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Effect getSpecialEffect() {
        return effect;
    }

    public void setSpecialEffect(Effect specialVal) {
        this.effect = specialVal;
    }
    
    public void reverseEffect(boolean dir) {
        dir = !dir;
    }
    
    public void skipEffect(int index) {
        index = index + 2;
    }
    
    @Override
    public String toString() {
        return String.format("%s %s", super.getValue().getValueName(),
                super.getSuit().getSuitName());
    }
}