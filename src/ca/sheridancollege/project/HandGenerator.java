/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class is used to generate a player's hand using random cards from a 
 * Deck object.
 * 
 * @author Edgar Chavez June 2020
 */
public class HandGenerator {
    
    private final Deck originDeck;
    private final int handSize;

    /**
     * The default constructor for HandGenerator takes a Deck object and hand
     * size to generate the hand.
     * 
     * @param originDeck The deck the cards will come from.
     * @param handSize The size of the resulting hand.
     */
    public HandGenerator(Deck originDeck, int handSize) {
        this.originDeck = originDeck;
        this.handSize = handSize;
    }
    
    /**
     * This method will take the Deck object and generate a hand of the desired
     * size.
     * 
     * @return The Hand object containing the cards taken from the deck. 
     */
    public Hand create(){
        ArrayList<Card> hand = new ArrayList<Card>();
        ArrayList<Card> deck = this.originDeck.getCards();
        
        for (int i = 0; i < this.handSize; i++) {
            int random = new Random().nextInt(deck.size());
            Card randomCard = deck.get(random);
            hand.add(randomCard);
            deck.remove(randomCard);
        }
        
        Hand unoHand = new Hand(hand);
        
        return unoHand;
    }
    
}
