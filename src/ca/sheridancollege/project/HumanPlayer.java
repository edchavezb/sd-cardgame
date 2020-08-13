package ca.sheridancollege.project;

/**
 * This class models a human player in the game.
 * 
 * @author Edgar Chavez June 2020
 * @author Safi Khalid June 2020
 */
public class HumanPlayer extends Player {
    
    public HumanPlayer(String name) {
        super(name);
    }
    
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
        
        // Print the card the player used.
        System.out.printf("%s played %s%n%n", this.getName(), card);
    }
    
}