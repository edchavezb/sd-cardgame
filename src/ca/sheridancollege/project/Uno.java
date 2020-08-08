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
        
        DeckGenerator numberedCards = new DeckGenerator(Number.class, Color.class);
        cards.addAll(numberedCards.create());
        
        DeckGenerator specialCards = new DeckGenerator(Effect.class, Color.class);
        cards.addAll(specialCards.create());
        
        Deck unoDeck = new Deck(cards);
        this.setDeck(unoDeck);
        
        DiscardPile discard = new DiscardPile(new ArrayList<Card>());
        this.setDiscardPile(discard);
        
        System.out.println(unoDeck.getCards().size());
        
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
        
        System.out.println("Hands created");
        System.out.println(unoDeck.getCards().size());
        
    }
    
    @Override
    public void play(){
        int playerIndex = this.getCurrentPlayer();
        Player currentPlayer = this.getPlayers().get(playerIndex);
        if (currentPlayer instanceof HumanPlayer){
            this.userTurn(currentPlayer);
        } else {
            this.computerTurn(currentPlayer);
        }
    }
    
    @Override
    public void declareWinner() {
        
    }
    
    public void userTurn(Player player) {
        Card modelCard = this.getDiscardPile().getCardOnTop();
        Hand playerHand = player.getPlayerHand();
        System.out.println("User turn: " + player.getName());
        System.out.println("Last card played: " + modelCard);
    }
    
    public void computerTurn(Player player) {
        Card modelCard = this.getDiscardPile().getCardOnTop();
        System.out.println("Computer turn: " + player.getName());
        System.out.println("Last card played: " + modelCard);
    }
    
}
