package ca.sheridancollege.project;

public class HumanPlayer extends Player {
    
    public HumanPlayer(String name) {
        super(name);
    }

    public void playCard() {}
    
    @Override
    public void draw(int drawAmount) {}
    
    @Override
    public void play() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}