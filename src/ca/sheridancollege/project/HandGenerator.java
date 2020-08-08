/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author 213388
 */
public class HandGenerator {
    
    private final Deck originDeck;
    private final int handSize;

    public HandGenerator(Deck originDeck, int handSize) {
        this.originDeck = originDeck;
        this.handSize = handSize;
    }
    
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
