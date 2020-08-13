/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.Random;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @author Safi Khalid Jun 2020
 */
public abstract class Player {

    private String name; //the unique name for this player
    private Hand playerHand;

    /**
     * A constructor that allows you to set the player's unique ID
     *
     * @param name the unique ID to assign to this player.
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * @return the player name
     */
    public String getName() {
        return name;
    }

    /**
     * Ensure that the playerID is unique
     *
     * @param name the player name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Retrieves this player's hand.
     * 
     * @return The player's hand. 
     */
    public Hand getPlayerHand() {
        return playerHand;
    }

    /**
     * Gives the player a hand to play with.
     * 
     * @param playerHand The hand the player will play with.
     */
    public void setPlayerHand(Hand playerHand) {
        this.playerHand = playerHand;
    }
    
    /**
     * This method takes a random card or cards from the deck and adds it to the player's hand.
     * 
     * @param drawAmount The amount of cards the player will draw.
     * @param deck The deck the cards will come from.
     */
    public void draw(int drawAmount, Deck deck) {
        for (int i = 0; i < drawAmount; i++) {
            int random = new Random().nextInt(deck.getCards().size());
            Card drawCard = deck.getCards().get(random);
            this.getPlayerHand().getCards().add(drawCard);
            deck.getCards().remove(drawCard);
        }
        System.out.printf("%s drew %d card(s)%n%n", this.getName(), drawAmount);
    }
    
    
    /**
     * The method to be overridden when you subclass the Player class with your specific type of Player and filled in
     * with logic to play your game.
     */
    public abstract void play(Card card, DiscardPile discard);

}
