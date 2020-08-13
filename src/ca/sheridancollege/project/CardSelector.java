/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * This class is used during a computer player's turn to decide the best card
 * to play from its hand.
 * 
 * @author Edgar Chavez June 2020
 */
public class CardSelector {
    
    private Hand hand;
    private Card cardToMatch;

    /**
     * Default constructor method for the CardSelector class. It takes a Hand
     * object and a Card object to process the decision.
     * 
     * @param hand The Hand object that represents the hand of the computer player.
     * @param cardToMatch The Card that the player's hand will be compared to.
     */
    public CardSelector(Hand hand, Card cardToMatch) {
        this.hand = hand;
        this.cardToMatch = cardToMatch;
    }

    /**
     * Retrieves the Hand object that contains the player's cards.
     * 
     * @return The computer player's hand.
     */
    public Hand getHand() {
        return hand;
    }

    /**
     * Establishes the Hand object to make the comparison with.
     * 
     * @param hand The computer player's hand.
     */
    public void setHand(Hand hand) {
        this.hand = hand;
    }

    /**
     * Retrieves the Card object that the hand is compared with.
     * 
     * @return The Card the player's hand will be compared with.
     */
    public Card getCardToMatch() {
        return cardToMatch;
    }

    /**
     * Establishes the Card object to make the comparison with.
     * 
     * @param cardToMatch The Card that the player's hand will be compared with.
     */
    public void setCardToMatch(Card cardToMatch) {
        this.cardToMatch = cardToMatch;
    }
    
    /**
     * Method that finds the best card to be played.
     * 
     * @return The card the computer player will play.
     */
    public Card decide(){
        Hand decideHand = this.hand;
        ArrayList<Card> handCards = decideHand.getCards();
        Card chosenCard = null;
        
        // If the player has a Wild card, this one will always be played first.
        for(Card card : handCards){
            if (card.getValue() == Effect.WILD){
                return card;
            }
        }
        
        // If the player has any cards that match the model's color or value, 
        // it will be chosen.
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
        
        // Finally, if the player has none of the previous cards, 
        // they will be allowed to play a Wild Draw Four.
        for(Card card : handCards){
            if (card.getValue() == Effect.FOUR){
                return card;
            }
        }
        
        // If no playable cards were found, the method will return a null Card object.
        return chosenCard;
    }
    
}
