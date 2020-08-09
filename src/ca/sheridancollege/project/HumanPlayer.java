package ca.sheridancollege.project;

public class HumanPlayer extends Player {
    
    public HumanPlayer(String name) {
        super(name);
    }
    
    @Override
    public void play(Card card, DiscardPile discard) {
        if (card instanceof SpecialCard){
            SpecialCard effectCard = (SpecialCard) card;
            effectCard.useEffect(this);
        }
        discard.getCards().add(card);
        discard.setCardOnTop();
        this.getPlayerHand().getCards().remove(card);
        System.out.printf("%s played %s%n%n", this.getName(), card);
    }
    
}