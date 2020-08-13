package ca.sheridancollege.project;

/**
 * This class models a numbered card that can be played in the Uno game.
 * 
 * @author Edgar Chavez June 2020
 */
public class NumberedCard extends Card {
    
    /**
     * The default constructor takes a value and a suit to be assigned to the
     * card, and a Game object where the card is played.
     * 
     * @param value The number of the card.
     * @param suit The suit of the card.
     * @param game The game this card is played on.
     */
    public NumberedCard(Value value, Suit suit, Game game) {
        super(value, suit, game);
    }
    
    @Override
    public String toString() {
        return String.format("%s %s", super.getValue().getValueName(),
                super.getSuit().getSuitName());
    }
}