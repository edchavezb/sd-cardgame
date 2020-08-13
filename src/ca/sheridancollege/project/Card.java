/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * @author dancye
 * @author Safi Khalid Jun 2020
 * @author Edgar Chavez Jun 2020
 */
public abstract class Card {
    //default modifier for child classes
    private Value value;
    private Suit suit;
    private Game game;
    
    /**
     * Default constructor for the Card class. It takes value, suit, and
     * game parameters.
     * 
     * @param value The value of this card, either number or effect
     * @param suit The suit of this card, which in Uno is a color
     * @param game The game this card is played on, in case it has an effect
     */
    public Card(Value value, Suit suit, Game game) {
        this.value = value;
        this.suit = suit;
        this.game = game;
    }

    /**
     * Retrieves the value of this card.
     * 
     * @return The value of the card. Either a number or an effect in Uno.
     */
    public Value getValue() {
        return value;
    }

    /**
     * Establishes the value of this card.
     * 
     * @param value The value given to this card. It can be a number or effect.
     */
    public void setValue(Value value) {
        this.value = value;
    }

    /**
     * Retrieves the suit of this card.
     * 
     * @return The suit of this card. In Uno, it will be a color.
     */
    public Suit getSuit() {
        return suit;
    }
    
    /**
     * Establishes the suit for this card.
     * 
     * @param suit The suit of this card. In Uno, it will be a color.
     */
    public void setSuit(Suit suit) {
        this.suit = suit;
    }
    
    /**
     * Retrieves the game this card is being played on.
     * 
     * @return The game this card is being played on, in case it has an effect.
     */
    public Game getGame() {
        return game;
    }

    /**
     * Establishes the game object this card belongs to.
     * 
     * @param game The game this card is being played on, in case it has an effect.
     */
    public void setGame(Game game) {
        this.game = game;
    }
    
    /**
     * Students should implement this method for their specific children classes
     *
     * @return a String representation of a card. Could be an UNO card, a regular playing card etc.
     */
    @Override
    public abstract String toString();

}
