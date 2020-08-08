package ca.sheridancollege.project;

import java.util.ArrayList;

public class DiscardPile extends GroupOfCards {
    
    private Card cardOnTop;
    
    public DiscardPile(ArrayList<Card> cards) {
        super(cards);
    }

    public Card getCardOnTop() {
        return cardOnTop;
    }

    public void setCardOnTop() {
        
        if (this.getCards() != null && !this.getCards().isEmpty()) {
            int lastIndex = this.getCards().size() - 1;
            Card lastCard = this.getCards().get(lastIndex);
            this.cardOnTop = lastCard;
        }

    }
    
}