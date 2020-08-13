/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

/**
 * A main class to create an Uno object and run the game.
 * 
 * @author Edgar Chavez June 2020
 */
public class Main {
    public static void main(String[] args){
        
        Uno myUno = new Uno();
        myUno.prepareGame();
        myUno.play();
    }
}
