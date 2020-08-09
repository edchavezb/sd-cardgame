package ca.sheridancollege.project;

import java.util.Random;
import java.util.Scanner;

public class SpecialCard extends Card {
    
    /**
    * 
    * @param value
    * @param suit
    * @param game
    */
    public SpecialCard(Value value, Suit suit, Game game) {
        super(value, suit, game);
    }
    
    public void reverseEffect() {
        System.out.println(this.getGame());
        this.getGame().setDirClockwise(!this.getGame().isDirClockwise());
    }
    
    public void skipEffect(boolean draw, int drawAmt) {
        Game game = this.getGame();
        int index = game.getCurrentPlayer();
        boolean clockwise = game.isDirClockwise();
        Player nextPlayer = clockwise ? game.getPlayers().get(index + 1)
                : game.getPlayers().get(index - 1);
        
        System.out.println(this.getGame());
        
        if (draw){
            nextPlayer.draw(drawAmt, game.getDeck());
        }
                
        if (clockwise){
            if (index == this.getGame().getPlayers().size() - 1){
                index = 0;
            } else {
                index = index++;
            }
        } else {
            if (index == 0){
                index = this.getGame().getPlayers().size() - 1;
            } else {
                index = index--;
            }
        }
        this.getGame().setCurrentPlayer(index);  
    }
    
    public void wildEffect(boolean prompt){
        Scanner scan = new Scanner(System.in);
        int colorIndex;

        if (prompt){
            System.out.println("Available colors: ");
            for(Color color : Color.values()){
                System.out.printf("%d - %s%n", color.ordinal() + 1, color.getSuitName());
            }
            
            System.out.println("Enter the number of the color you want: ");
            colorIndex = scan.nextInt() - 1;
        } else {
            colorIndex = new Random().nextInt(Color.values().length);
        }
        
        this.setSuit(Color.values()[colorIndex]);
        System.out.println("Selected color: " + Color.values()[colorIndex].getSuitName());
    }
    
    public void useEffect(Player player){
        boolean prompt = player instanceof HumanPlayer;
        Effect effect = (Effect)this.getValue();
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
                System.out.println("Ok sum happened");
        }
    }
    
    @Override
    public String toString() {
        String cardInfo = (this.getValue() == Effect.WILD ||
                this.getValue() == Effect.FOUR) ?
                String.format("%s", super.getValue().getValueName()) 
                : String.format("%s %s", super.getValue().getValueName(),
                super.getSuit().getSuitName());
        return cardInfo;
    }
}