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
 *
 * @author 213388
 */
public class Uno extends Game {      
    
    /**
     * Will prepare the deck, players and create hand objects
     * 
     */
    @Override
    public void prepareGame(){
        
        Scanner scan = new Scanner(System.in);
        
        ArrayList<Card> cards = new ArrayList();
        
        DeckGenerator numberedCards = new DeckGenerator(Number.class, Color.class, this);
        cards.addAll(numberedCards.create());
        
        DeckGenerator specialCards = new DeckGenerator(Effect.class, Color.class, this);
        cards.addAll(specialCards.create());
        
        Deck unoDeck = new Deck(cards);
        this.setDeck(unoDeck);
        
        DiscardPile discard = new DiscardPile(new ArrayList<Card>());
        this.setDiscardPile(discard);
        
        ArrayList<Player> players = new ArrayList();
        HandGenerator unoHand = new HandGenerator(this.getDeck(), 7);
        
        System.out.print("How many human players will this round have? ");
        int numHumans = scan.nextInt();
        for (int i = 1; i <= numHumans; i++) {
            System.out.println("Enter the name of player number " + i + ": ");
            String playerName = scan.next();
            Player player = new HumanPlayer(playerName);
            player.setPlayerHand(unoHand.create());
            players.add(player);
        }
        
        System.out.print("How many computer players will this round have? ");
        int numComputers = scan.nextInt();
        for (int i = 1; i <= numComputers; i++) {
            String playerName = "COM" + i;
            Player player = new ComputerPlayer(playerName);
            player.setPlayerHand(unoHand.create());
            players.add(player);
        }
        
        Collections.shuffle(players);
        this.setPlayers(players);
        
        int random = new Random().nextInt(unoDeck.getCards().size());
        Card randomCard = unoDeck.getCards().get(random);
        discard.getCards().add(randomCard);
        discard.setCardOnTop();
        
        System.out.println("Let's play UNO!\n");       
    }
    
    @Override
    public void play(){
        boolean victory = false;
        do {
            int playerIndex = this.getCurrentPlayer();
            Player currentPlayer = this.getPlayers().get(playerIndex);
            if (currentPlayer instanceof HumanPlayer){
                this.userTurn(currentPlayer);
            } else {
                this.computerTurn(currentPlayer);
            } 
            
            playerIndex = this.getCurrentPlayer();
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
            
            this.setCurrentPlayer(playerIndex);
            victory = checkVictory();
        } while (!victory);
        this.declareWinner(this.getWinner());
    }
    
    public boolean checkVictory(){
        for(Player player : this.getPlayers()){
            if (player.getPlayerHand().getCards().isEmpty()){
                this.setWinner(player);
                return true;
            }
        }
        return false;
    }
      
    @Override
    public void declareWinner(Player player) {
        System.out.println(player.getName() + " is the WINNER!");
    }
    
    public void userTurn(Player player) {
        Scanner scan = new Scanner(System.in);
        
        Deck currentDeck = this.getDeck();
        Card modelCard = this.getDiscardPile().getCardOnTop();
        Hand playerHand = player.getPlayerHand();
        ArrayList<Card> playerCards = playerHand.getCards();
        
        System.out.println("User turn: " + player.getName());
        System.out.printf("Last card played: %s %s%n", modelCard.getValue().getValueName(), modelCard.getSuit().getSuitName());
        System.out.println("Your hand:");
        for (Card card : playerCards){
            System.out.printf("%d - %s%n", playerCards.indexOf(card) + 1, card);
        }
        
        boolean validCard = true;
            
        do {
            System.out.println("Enter your action: 1 - Play a card 2 - Draw a card");
            int action = scan.nextInt();
        
            if (action == 1){

                System.out.println("Enter the number of the card to play: ");
                int playIndex = scan.nextInt() - 1;
                Card playCard = playerCards.get(playIndex);

                if(CardValidator.check(playCard, playerHand, modelCard)){
                    player.play(playCard, this.getDiscardPile());
                    validCard = true;
                } else {
                    System.out.println("This card cannot be played. Please choose another one");
                    validCard = false;
                }
                
            } else if (action == 2){
                player.draw(1, currentDeck);
            }
        
        } while (validCard == false);
    }
    
    public void computerTurn(Player player) {
        Card modelCard = this.getDiscardPile().getCardOnTop();
        Hand playerHand = player.getPlayerHand();

        System.out.println("Computer turn: " + player.getName());
        System.out.println("Last card played: " + modelCard);
        
        CardSelector selector = new CardSelector(playerHand, modelCard);
        Card playCard = selector.decide();
        
        if (playCard != null){
            player.play(playCard, this.getDiscardPile());
        } else {
            player.draw(1, this.getDeck());
        }
        
    }
    
}
