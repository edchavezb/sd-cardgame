package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * This class models the discard pile the played cards will be placed into.
 * 
 * @author Edgar Chavez June 2020
 */
public class DiscardPile extends GroupOfCards {
    
    private Card cardOnTop;
    
    /**
     * The default constructor of the DiscardPile takes an empty ArrayList of
     * Card objects.
     * 
     * @param cards The empty ArrayList of cards the pile will use.
     */
    public DiscardPile(ArrayList<Card> cards) {
        super(cards);
    }
    
    /**
     * Retrieves the card on top of the discard pile.
     * 
     * @return The card on top of the dicard pile.
     */
    public Card getCardOnTop() {
        return cardOnTop;
    }

    /**
     * Establishes the card on top as the last index in the collection.
     */
    public void setCardOnTop() {
        
        if (this.getCards() != null && !this.getCards().isEmpty()) {
            int lastIndex = this.getCards().size() - 1;
            Card lastCard = this.getCards().get(lastIndex);
            this.cardOnTop = lastCard;
        }

    }
    
}