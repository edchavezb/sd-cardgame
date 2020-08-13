package ca.sheridancollege.project;

/**
 * This class models a computer player in the game.
 * 
 * @author Edgar Chavez June 2020
 * @author Safi Khalid June 2020
 */
public class ComputerPlayer extends Player {

    /**
     * Default constructor for the ComputerPlayer class. It takes a name string.
     * 
     * @param name The name given automatically to the computer player.
     */
    public ComputerPlayer(String name) {
        super(name);
    }
    
    /**
     * The method this player uses to play a card in their hand.
     * 
     * @param card The card the player will play.
     * @param discard The discard pile where the card will be placed.
     */
    @Override
    public void play(Card card, DiscardPile discard) {
        
        // If the card is an effect card, its effect is activated.
        if (card instanceof SpecialCard){
            SpecialCard effectCard = (SpecialCard) card;
            effectCard.useEffect(this);
        }
        
        // The card is added to the discard pile and removed from the player's hand.
        discard.getCards().add(card);
        discard.setCardOnTop();
        this.getPlayerHand().getCards().remove(card);
        
        // Print the card the player used and the remaining number of cards in their hand.
        System.out.printf("%s played %s%n", this.getName(), card);
        System.out.printf("%s now has %d cards%n%n", this.getName(), this.getPlayerHand().getCards().size());
    }
}