/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The class that models your game. You should create a more specific child of this class and instantiate the methods
 * given.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @author Safi Khalid Jun 2020
 */
public abstract class Game {

    private ArrayList<Player> players;// the players of the game
    private boolean dirClockwise;
    private int currentPlayer;
    private DiscardPile discard;
    private Deck deck;
    
    
    public Game() {
        players = new ArrayList();
    }

    /**
     * will prepare the players and create hand objects
     * @param players
     */
    public void prepareGame() {
        Scanner scan = new Scanner(System.in);
        System.out.print("How many human players will this round have?");
        int humans = scan.nextInt();
        System.out.print("How many computer players will this round have?");
        int computers = scan.nextInt();
        
        for (int i = 0; i <= humans; i++) {
            System.out.println("Enter the name of player number " + i + ": ");
            String playerName = scan.next();
            Player player = new HumanPlayer(playerName);
        }
        
    }
    
    public void userTurn() {}
    
    public void computerTurn() {}
    
    


    /**
     * @return the players of this game
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * @param players the players of this game
     */
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    /**
     * Play the game. This might be one method or many method calls depending on your game.
     */
    public abstract void play();

    /**
     * When the game is over, use this method to declare and display a winning player.
     */
    public abstract void declareWinner();

}//end class
