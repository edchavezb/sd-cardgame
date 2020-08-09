/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author 213388
 */
public class CardSelector {
    
    private Hand hand;
    private Card cardToMatch;

    public CardSelector(Hand hand, Card cardToMatch) {
        this.hand = hand;
        this.cardToMatch = cardToMatch;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }
    
    public Card decide(){
        Hand decideHand = this.hand;
        ArrayList<Card> handCards = decideHand.getCards();
        Card chosenCard = null;
        
        for(Card card : handCards){
            if (card.getValue() == Effect.WILD){
                return card;
            }
        }
        
        for(Card card : handCards){
            if (card.getValue() != Effect.FOUR &&
                    (
                        card.getValue() == this.cardToMatch.getValue()
                        || card.getSuit() == this.cardToMatch.getSuit()
                    )
                ){
                return card;
            }
        }
        
        for(Card card : handCards){
            if (card.getValue() == Effect.FOUR){
                return card;
            }
        }
        
        return chosenCard;
    }
    
}
