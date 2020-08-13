/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 * A class that models the logic of the Uno card game.
 * 
 * @author Edgar Chavez June 2020
 * @author Safi Khalid June 2020
 */
public class Uno extends Game {      
    
    /**
     * This method prepares the deck, players and creates hand objects.
     */
    @Override
    public void prepareGame(){
        
        Scanner scan = new Scanner(System.in);
        
        ArrayList<Card> cards = new ArrayList();
        
        // Generate a deck of numbered cards.
        DeckGenerator numberedCards = new DeckGenerator(Number.class, Color.class, this);
        cards.addAll(numberedCards.create());
        
        // Generate a deck of special cards.
        DeckGenerator specialCards = new DeckGenerator(Effect.class, Color.class, this);
        cards.addAll(specialCards.create());
        
        // Put the two decks together in a new Deck object.
        Deck unoDeck = new Deck(cards);
        
        // Assign the deck to this game.
        this.setDeck(unoDeck);
        
        // Create the discard pile and assign it to the game.
        DiscardPile discard = new DiscardPile(new ArrayList<Card>());
        this.setDiscardPile(discard);
        
        // Create an empty collection of players and a hand generator object.
        ArrayList<Player> players = new ArrayList();
        HandGenerator unoHand = new HandGenerator(this.getDeck(), 7);
        
        int numPlayers;
        int numHumans;
        int numComputers;
        
        // Get the number of human players the game will have.
        do {
            System.out.print("How many human players will this round have? ");
            
            // Make sure the user enters a number.
            while (!scan.hasNextInt()) {
                System.out.println("Error: Please enter a number");
                scan.next();
            }
            numHumans = scan.nextInt();
            
        } while (numHumans <= 0); // Make sure the user enters a positive number.
        
        scan.nextLine();
        
        // Ask the user to enter unique names for each human player.
        for (int i = 1; i <= numHumans; i++) {
            System.out.print("Enter the name of player number " + i + ": ");
            String playerName = scan.nextLine();
            Player player = new HumanPlayer(playerName);
            
            // Create and set the hand for the player.
            player.setPlayerHand(unoHand.create());
            
            // Add a player to the collection of players.
            players.add(player);
        }
        
        do{
            do {
                
                // Get the number of computer players the game will have.
                System.out.print("How many computer players will this "
                        + "round have? ");
                
                // Make sure the user enters a number.
                while (!scan.hasNextInt()) {
                    System.out.println("Error: Please enter a number");
                    scan.next();
                }
                numComputers = scan.nextInt();
            } while (numComputers <= 0); // Make sure the user enters a positive number.
            numPlayers = numHumans + numComputers;
            if (numPlayers > 10){
                System.out.println("Error: There cannot be more than "
                        + "10 players in each round.");
            }
        } while (numPlayers > 10); // Make sure the total number of players does not exceed ten.
        
        // Assign names automatically to each computer player.
        for (int i = 1; i <= numComputers; i++) {
            String playerName = "COM" + i;
            Player player = new ComputerPlayer(playerName);
            
            // Create and set the hand for the player.
            player.setPlayerHand(unoHand.create());
            
            // Add a player to the collection of players.
            players.add(player);
        }
        
        // Shuffle the order of the players in the collection.
        Collections.shuffle(players);
        
        // Assign the collection of players to the game.
        this.setPlayers(players);
        
        // Retrieve a random card from the deck and place it as the first card
        // in the discard pile.
        int random = new Random().nextInt(unoDeck.getCards().size());
        Card randomCard = unoDeck.getCards().get(random);
        discard.getCards().add(randomCard);
        discard.setCardOnTop();
        
        System.out.println("Let's play UNO!\n");       
    }
    
    /**
     * This method takes care of the turn logic in the game.
     */
    @Override
    public void play(){
        boolean victory;
        do {
            
            // Retrieve the current player object.
            int playerIndex = this.getCurrentPlayer();
            Player currentPlayer = this.getPlayers().get(playerIndex);
            
            // Execute a different type of turn depending on the type of player.
            if (currentPlayer instanceof HumanPlayer){
                this.userTurn(currentPlayer);
            } else {
                this.computerTurn(currentPlayer);
            }
            
            // Move the turn forward to the next player at the end of each turn.
            this.setCurrentPlayer(this.getNextPlayer());
            
            // Check for victory at the end of each turn.
            victory = checkVictory(); 
        } while (!victory); // Turns will continue until a victory is declared.
        this.declareWinner(this.getWinner());
    }
    
    /**
     * Loops through the collection of players and checks if their hand is empty.
     * 
     * @return True if a player has ran out of cards.
     */
    public boolean checkVictory(){
        for(Player player : this.getPlayers()){
            if (player.getPlayerHand().getCards().isEmpty()){
                this.setWinner(player);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Prints the name of the winner.
     * 
     * @param player The winner of the game.
     */
    @Override
    public void declareWinner(Player player) {
        System.out.println(player.getName() + " is the WINNER!");
    }
    
    /**
     * Implements the logic of a human player's turn.
     * 
     * @param player The human player.
     */
    public void userTurn(Player player) {
        Scanner scan = new Scanner(System.in);
        
        Deck currentDeck = this.getDeck();
        Card modelCard = this.getDiscardPile().getCardOnTop();
        Hand playerHand = player.getPlayerHand();
        ArrayList<Card> playerCards = playerHand.getCards();
        
        System.out.println("User turn: " + player.getName());
        
        // Shows the card on top of the discard pile.
        System.out.printf("Last card played: %s %s%n", 
                modelCard.getValue().getValueName(),
                modelCard.getSuit().getSuitName());
        
        // Prints all the cards in the player's hand.
        System.out.println("Your hand:");
        for (Card card : playerCards){
            System.out.printf("%d - %s%n", playerCards.indexOf(card) + 1, card);
        }
        
        boolean validCard = true;
            
        do {
            
            boolean isNumber;
            int action;
            String input;
                 
            do {
                
                // The user decides between playing and drawing a card.
                System.out.println("\nEnter your action:\n"
                        + "1 - Play a card\n" + "2 - Draw a card\n" 
                        + "Other - Pass");
                isNumber = scan.hasNextInt();
                input = scan.next();
                if (!isNumber){
                    System.out.println("Error: Please enter a number");
                }
            } while (!isNumber); // Make sure the user enters a number.
            
            action = Integer.parseInt(input);
            
            // The user has chosen to play a card.
            if (action == 1){
                
                int playIndex;
                
                do {
                    System.out.println("Enter the number of the card to play: ");
                    while (!scan.hasNextInt()) {
                        
                        // Make sure the user enters a number.
                        System.out.print("Please enter a number");
                    }
                    playIndex = scan.nextInt() - 1;
                    if (playIndex + 1 > playerCards.size() || playIndex < 0){
                        
                        // Make sure the card is in the player's hand. 
                        System.out.println("Error: This card is not in your hand.");
                    }
                } while (playIndex + 1 > playerCards.size() || playIndex < 0);
                
                // Retrieve the selected card from the player's hand.
                Card playCard = playerCards.get(playIndex);

                // If a card is valid, play it.
                if(CardValidator.isValid(playCard, playerHand, modelCard)){
                    player.play(playCard, this.getDiscardPile());
                    validCard = true;
                } else {
                    System.out.println("This card cannot be played. Please choose another one");
                    validCard = false;
                }
                
            } else if (action == 2){
                
                // The user has chosen to draw a card.
                player.draw(1, currentDeck);
            }
        
        } while (validCard == false); // Make sure the card can be played.
    }
    
    /**
     * Implements the logic of a computer player's turn.
     * 
     * @param player The computer player.
     */
    public void computerTurn(Player player) {
        Card modelCard = this.getDiscardPile().getCardOnTop();
        Hand playerHand = player.getPlayerHand();

        System.out.println("Computer turn: " + player.getName());
        
        // Show the card on top of the discard pile.
        System.out.printf("Last card played: %s %s%n", 
                modelCard.getValue().getValueName(), 
                modelCard.getSuit().getSuitName());
        
        // Use the algorithm to select a card from the hand.
        CardSelector selector = new CardSelector(playerHand, modelCard);
        Card playCard = selector.decide();
        
        // If there are no playable cards, the computer player will draw.
        if (playCard != null){
            player.play(playCard, this.getDiscardPile());
        } else {
            player.draw(1, this.getDeck());
        }
        
    }
    
}
