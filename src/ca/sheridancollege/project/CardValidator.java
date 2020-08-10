/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

/**
 *
 * @author 213388
 */
public class CardValidator {
    
    
    public static boolean check(Card card, Hand hand, Card cardToMatch){
        
        boolean canPlayDrawFour = true;
        
        for(Card handCard : hand.getCards()){
            if (handCard.getValue() != Effect.FOUR &&
                    (handCard.getValue() == cardToMatch.getValue()
                    || handCard.getSuit() == cardToMatch.getSuit())){
                canPlayDrawFour = false;
            }
        }
        
        if (card.getValue() == Effect.WILD){
            return true;
        }
        
        if (card.getValue() != Effect.FOUR &&
                    (card.getValue() == cardToMatch.getValue()
                    || card.getSuit() == cardToMatch.getSuit())){
            return true;
        }
        
        if (card.getValue() == Effect.FOUR && canPlayDrawFour){
            return true;
        }
        
        return false;
    }
}
