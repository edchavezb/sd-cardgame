package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * This class models the deck that will be used to generate the players' hands
 * and for the players to draw cards during their turn.
 * 
 * @author Edgar Chavez June 2020
 */
public class Deck extends GroupOfCards {
    
    /**
     * Default constructor for the Deck class. It takes an ArrayList of Card
     * objects.
     * 
     * @param cards The cards to be included in the deck.
     */
    public Deck(ArrayList<Card> cards) {
        super(cards);
    }
    
}