/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * The class that models your game. You should create a more specific child of this class and instantiate the methods
 * given.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @author Safi Khalid Jun 2020
 * @author Edgar Chavez Jun 2020
 */
public abstract class Game {

    private ArrayList<Player> players;// the players of the game
    private boolean dirClockwise = true;
    private int currentPlayer = 0;
    private DiscardPile discardPile;
    private Deck deck;
    private Player winner;
    
    public Game() {
        players = new ArrayList();
    }
    
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
     * Checks if the game's direction is clockwise or not.
     * 
     * @return The direction of the game.
     */
    public boolean isDirClockwise() {
        return dirClockwise;
    }

    /**
     * Establishes the direction of the turns in the game.
     * 
     * @param dirClockwise The direction of the game.
     */
    public void setDirClockwise(boolean dirClockwise) {
        this.dirClockwise = dirClockwise;
    }

    /**
     * Retrieves the index of the current player.
     * 
     * @return The index of the current player.
     */
    public int getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Establishes the index of the current player.
     * 
     * @param currentPlayer The index of the current player.
     */
    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
    
    /**
     * Determines the index of the next player based on the direction of the game.
     * 
     * @return The index of the next player.
     */
    public int getNextPlayer(){
        int playerIndex = this.getCurrentPlayer();
        if (this.isDirClockwise()){
            if (playerIndex == this.getPlayers().size() - 1){
                playerIndex = 0;
            } else {
                playerIndex++;
            }
        } else {
            if (playerIndex == 0){
                playerIndex = this.getPlayers().size() - 1;
            } else {
                playerIndex--;
            } 
        }
        return playerIndex;
    }

    /**
     * Retrieves the DiscardPile object owned by this game.
     * 
     * @return The discard pile used in the game.
     */
    public DiscardPile getDiscardPile() {
        return discardPile;
    }

    /**
     * Gives this game a discard pile to be used each turn.
     * 
     * @param discard The discard pile used during the game.
     */
    public void setDiscardPile(DiscardPile discard) {
        this.discardPile = discard;
    }

    /**
     * Retrieves the Deck object being used in the game.
     * 
     * @return The deck used during the game.
     */
    public Deck getDeck() {
        return deck;
    }

    /**
     * Gives this game a Deck object to use during the game.
     * 
     * @param deck The deck used during the game.
     */
    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    /**
     * Retrieves the player that has won the game.
     * 
     * @return The player who has won the game.
     */
    public Player getWinner() {
        return winner;
    }

    /**
     * Establishes the player who has won the game.
     * 
     * @param winner The player who has won the game.
     */
    public void setWinner(Player winner) {
        this.winner = winner;
    }
    
    /**
     * The method that takes care of preparing the deck, players, and hands.
     */
    public void prepareGame() {}

    /**
     * Play the game. This might be one method or many method calls depending on your game.
     */
    public abstract void play();

    /**
     * When the game is over, use this method to declare and display a winning player.
     * @param player The player to be declared winner.
     */
    public abstract void declareWinner(Player player);

}//end class
