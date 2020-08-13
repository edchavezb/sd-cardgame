/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * This class is used to generate a complete deck from a value enum and a suit enum.
 * 
 * @author Edgar Chavez
 */
public class DeckGenerator {
    
    private final Class<? extends Enum<?>> value;
    private final Class<? extends Enum<?>> suit;
    private final Game game;

    /**
     * The default constructor for the DeckGenerator class takes two enum classes, 
     * one for the values the cards will have and another for the suits. It also
     * takes a Game object in order to assign the deck to it.
     * 
     * @param value The enum class that contains all the values for the deck.
     * @param suit The enum class that containes the suits for the deck.
     * @param game The Game object the deck will be assigned to.
     */
    public DeckGenerator(Class<? extends Enum<?>> value, 
            Class<? extends Enum<?>> suit, Game game) {
        this.value = value;
        this.suit = suit;
        this.game = game;
    }
    
    /**
     * The create() method takes the two enum classes and creates as many copies 
     * of cards of each suit as specified in a given value in the value enum 
     * class. Zero can have 1 copy of each suit while other cards can have 2.
     * 
     * @return The collection of cards to be added to a Deck object.
     */
    public ArrayList<Card> create(){
        
        ArrayList<Card> deck = new ArrayList<Card>();
        
        // If the value enum class implements the Special interface, the 
        // method will generate objects of the SpecialCard class.
        boolean specialDeck = Special.class.isAssignableFrom(this.value);
        
        // Loop through all the constants in the value enum class
        for(Object o: value.getEnumConstants()) {
            Value cardValue = (Value)o;
            
            // How many sets of each suit will this value have?
            int numSets = cardValue.getNumSuitSets();
            
            // Generate all the necessary copies of each suit for that value
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