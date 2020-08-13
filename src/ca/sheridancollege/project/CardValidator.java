/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

/**
 * This class is used during a human player's turn to determine if the card the
 * player selected is a valid card to play in this turn.
 * 
 * @author Edgar Chavez June 2020
 */
public class CardValidator {
    
    /**
     * This method returns a boolean value that determines if the card the
     * player selected can be played.
     * 
     * @param card The card the player selected.
     * @param hand The hand that contains all the player's cards.
     * @param cardToMatch The model card to be compared with the selection.
     * @return The boolean value of a valid or invalid card.
     */
    public static boolean isValid(Card card, Hand hand, Card cardToMatch){
        
        boolean canPlayDrawFour = true;
        
        // If the user has any cards that match the model card, a Wild Draw Four cannot be played.
        for(Card handCard : hand.getCards()){
            if (handCard.getValue() != Effect.FOUR &&
                    (handCard.getValue() == cardToMatch.getValue()
                    || handCard.getSuit() == cardToMatch.getSuit())){
                canPlayDrawFour = false;
            }
        }
        
        // Wild cards can be played without any restrictions.
        if (card.getValue() == Effect.WILD){
            return true;
        }
        
        // If the card matches the color or value of the model, it can be played.
        if (card.getValue() != Effect.FOUR &&
                    (card.getValue() == cardToMatch.getValue()
                    || card.getSuit() == cardToMatch.getSuit())){
            return true;
        }
        
        // If the above check passed (line 22), the player can use the Wild Draw Four card.
        if (card.getValue() == Effect.FOUR && canPlayDrawFour){
            return true;
        }
        
        // If none of the cards are playable, the 
        return false;
    }
}
