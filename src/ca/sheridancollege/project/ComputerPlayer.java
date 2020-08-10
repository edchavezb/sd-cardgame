package ca.sheridancollege.project;

public class ComputerPlayer extends Player {

    public ComputerPlayer(String name) {
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
        System.out.printf("%s played %s%n", this.getName(), card);
        System.out.printf("%s now has %d cards%n%n", this.getName(), this.getPlayerHand().getCards().size());
    }
}