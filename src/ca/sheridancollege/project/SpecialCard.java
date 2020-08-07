package ca.sheridancollege.project;

public class SpecialCard extends Card {

    private Color color;
    private SpecialEffect specialEffect;
    private int drawAmount = 2;
    
    /**
	 * 
	 * @param color
	 * @param val
	 */
	private SpecialCard(Color color, SpecialEffect val) {
        this.color = color;
        this.specialEffect = val;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public SpecialEffect getSpecialEffect() {
        return specialEffect;
    }

    public void setSpecialEffect(SpecialEffect specialVal) {
        this.specialEffect = specialVal;
    }
    
    public void reverseEffect(boolean dir) {
        dir = !dir;
    }
    
    public void skipEffect(int index) {
        index = index + 2;
    }
    
    @Override
    public String toString() {
        return String.format("%s %s", color.getColorName(), specialEffect.getSpecialName());
    }
}