/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Edgar Chavez
 */
public class DeckGenerator {
    
    private final Class<? extends Enum<?>> value;
    private final Class<? extends Enum<?>> suit;
    private Game game;

    public DeckGenerator(Class<? extends Enum<?>> value, 
            Class<? extends Enum<?>> suit, Game game) {
        this.value = value;
        this.suit = suit;
        this.game = game;
    }
    
    public ArrayList<Card> create(){
        
        ArrayList<Card> deck = new ArrayList<Card>();
        boolean specialDeck = Special.class.isAssignableFrom(this.value);
        
        for(Object o: value.getEnumConstants()) {
            Value cardValue = (Value)o;
            int numSets = cardValue.getNumSuitSets();
            
            for (int i = 1; i <= numSets; i++) {
                
                for(Object p: suit.getEnumConstants()) {
                    Suit cardSuit = (Suit)p;
                    Card card = specialDeck? 
                            new SpecialCard(cardValue, cardSuit, this.game) : 
                            new NumberedCard(cardValue, cardSuit, this.game);
                    deck.add(card);
                }   
            }
            
        }
        
        return deck;
    }
    
}