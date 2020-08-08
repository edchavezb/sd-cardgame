/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
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
        
        ArrayList<Card> unoDeck = new ArrayList();
        
        DeckGenerator numberedCards = new DeckGenerator(Number.class, Color.class);
        unoDeck.addAll(numberedCards.create());
        
        DeckGenerator specialCards = new DeckGenerator(Effect.class, Color.class);
        unoDeck.addAll(specialCards.create());
        
        for(Card card : unoDeck){
            System.out.println(card.toString()); 
        }
        
        Scanner scan = new Scanner(System.in);
        System.out.print("How many human players will this round have? ");
        int humans = scan.nextInt();
        System.out.print("How many computer players will this round have? ");
        int computers = scan.nextInt();
        
        ArrayList<Player> humanPlayers = new ArrayList();
        ArrayList<Player> comPlayers = new ArrayList();
        
        for (int i = 1; i <= humans; i++) {
            System.out.println("Enter the name of player number " + i + ": ");
            String playerName = scan.next();
            Player player = new HumanPlayer(playerName);
        }
        
        for (int i = 1; i <= computers; i++) {
            String playerName = "COM" + i;
            Player player = new ComputerPlayer(playerName);
        }
        
    }
    
    @Override
    public void play(){
        
    }
    
    @Override
    public void declareWinner() {
        
    }
    
    
    
}
