package ca.sheridancollege.project;

public class NumberedCard extends Card {

    private Color color;
    private CardValues cardVal;
    
    private NumberedCard(Color color, CardValues val) {
        this.color = color;
        this.cardVal = val;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public CardValues getCardVal() {
        return cardVal;
    }

    public void setCardVal(CardValues cardVal) {
        this.cardVal = cardVal;
    }
    
    @Override
    public String toString() {
        return String.format("%s %d", color.getColorName(), cardVal.getValue());
    }
}