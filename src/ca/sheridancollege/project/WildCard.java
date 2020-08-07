package ca.sheridancollege.project;

import java.util.Scanner;



public class WildCard extends Card {

    private boolean drawFour;
    private int drawAmount = 4;
    

    
    /**
	 * 
	 * @param drawFour
	 */
	private WildCard(boolean drawFour) {
        this.drawFour = drawFour;
    }

    public boolean getDrawFour() {
        return drawFour;
    }

    public void setDrawFour(boolean drawFour) {
        this.drawFour = drawFour;
    }
    
    public String wildEffect() {
        Scanner in = new Scanner(System.in);
        
        System.out.println("What color do you want?");
        String color = in.next();
        
        return color;
        
    }
    
    @Override
    public String toString() {
        return drawFour ? "Wild Draw Four" : "Wild";
    }
}