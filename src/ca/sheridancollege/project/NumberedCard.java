package ca.sheridancollege.project;

public class NumberedCard extends Card {

    private Color color;
    private Number cardVal;
    
    public NumberedCard(Value value, Suit suit, Game game) {
        super(value, suit, game);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Number getCardVal() {
        return cardVal;
    }

    public void setCardVal(Number cardVal) {
        this.cardVal = cardVal;
    }
    
    @Override
    public String toString() {
        return String.format("%s %s", super.getValue().getValueName(),
                super.getSuit().getSuitName());
    }
}