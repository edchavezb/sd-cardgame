package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * This class models all the cards in the Uno game which have a special
 * effect.
 * 
 * @author Edgar Chavez June 2020
 */
public class SpecialCard extends Card {
    
    /**
    * The default constructor for this card takes a value, suit and a game in
    * which the card takes effect.
    * 
    * @param value The effect of the card.
    * @param suit The suit of the card.
    * @param game The game which will be affected by the card's effect.
    */
    public SpecialCard(Value value, Suit suit, Game game) {
        super(value, suit, game);
    }
    
    /**
     * This method changes the direction of the game to its opposite.
     */
    public void reverseEffect() {
        this.getGame().setDirClockwise(!this.getGame().isDirClockwise());
    }
    
    /**
     * This method is used by all the cards which skip a player's turn.
     * Some of them require the skipped player to draw cards. Which is determined
     * by the draw boolean, and the amount to draw by the drawAmt integer.
     * 
     * @param draw Whether the card will cause the skipped player to draw or not.
     * @param drawAmt The amount of cards the player will draw.
     */
    public void skipEffect(boolean draw, int drawAmt) {
        Game game = this.getGame();
        ArrayList<Player> players = game.getPlayers();
        
        // Determine who the next player is.
        int nextPlayer = game.getNextPlayer();
              
        // If the card makes the next player draw, call the draw() method on that player.
        if (draw){
            players.get(nextPlayer).draw(drawAmt, game.getDeck());
        }
        
        // Move the turn forward by one, so when the turn ends the next player is skipped.
        game.setCurrentPlayer(nextPlayer);  
    }
    
    /**
     * This method is used by all the cards that change the suit of the model card.
     * If the player is a human player, they will be prompted to choose a new suit.
     * 
     * @param prompt Whether the player will be asked for a new suit or not.
     */
    public void wildEffect(boolean prompt){
        Scanner scan = new Scanner(System.in);
        int colorIndex;
        
        // If the player is a human player, prompt the user for a new color.
        if (prompt){
            System.out.println("Available colors: ");
            
            // Print all the values in the color enum.
            for(Color color : Color.values()){
                System.out.printf("%d - %s%n", color.ordinal() + 1, color.getSuitName());
            }
                
            do {
                System.out.println("Enter the number of the color you want: ");
                
                // Make sure the player enters a number.
                while (!scan.hasNextInt()) {
                    System.out.print("Please enter a number");
                }
                colorIndex = scan.nextInt() - 1;
                
                // Make sure that the player enters a valid index.
                if (colorIndex + 1 > Color.values().length || colorIndex < 0){
                    System.out.println("Error: This color is not available");
                }
            } while (colorIndex + 1 > Color.values().length || colorIndex < 0);

        } else {
            
            // If a player is a computer player, choose a random color.
            colorIndex = new Random().nextInt(Color.values().length);
        }
        
        // Change the color of the played card so the next player has to match it.
        this.setSuit(Color.values()[colorIndex]);
        System.out.println("Selected color: " + Color.values()[colorIndex].getSuitName());
    }
    
    /**
     * This method checks the value of the card and calls the corresponding
     * effect method.
     * 
     * @param player The player who is using the special card.
     */
    public void useEffect(Player player){
        
        // Determines if the player is human or computer.
        boolean prompt = player instanceof HumanPlayer;
        Effect effect = (Effect)this.getValue();
        
        // Triggers the effect depending on the value of the card.
        switch (effect) {
            case SKIP:
                skipEffect(false, 0);
                break;
            case TWO:
                skipEffect(true, 2);
                break; 
            case REVERSE:
                reverseEffect();
                break;
            case WILD:
                wildEffect(prompt);
                break;
            case FOUR:
                wildEffect(prompt);
                skipEffect(true, 4);
                break;
            default:
                
                // The card has an effect not specified in the switch statement.
                System.out.println("Ok sum'n happened");
        }
    }
    
    @Override
    public String toString() {
        
        // If the card is a Wild card (no color), the color is not displayed. 
        String cardInfo = (this.getValue() == Effect.WILD ||
                this.getValue() == Effect.FOUR) ?
                String.format("%s", super.getValue().getValueName()) 
                : String.format("%s %s", super.getValue().getValueName(),
                super.getSuit().getSuitName());
        return cardInfo;
    }
}