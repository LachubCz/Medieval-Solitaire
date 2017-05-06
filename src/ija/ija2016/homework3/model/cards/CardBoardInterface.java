package ija.ija2016.homework3.model.cards;

public interface CardBoardInterface {
	public CardStack getSourcePack();
        
        public CardDeck getDeck(int index);
        
        public  CardStack getStack(int index);

        public boolean isGameOver();

        public CardHint hintForCard(Card toCard);

        public int createHint(Card toCard);
}
