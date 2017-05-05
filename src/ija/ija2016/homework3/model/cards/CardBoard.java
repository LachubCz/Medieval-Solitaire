package ija.ija2016.homework3.model.cards;

import ija.ija2016.homework3.model.board.AbstractFactorySolitaire;
import ija.ija2016.homework3.model.board.FactoryKlondike;
import ija.ija2016.homework3.model.cards.CardDeck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class CardBoard implements CardBoardInterface{
        protected CardDeck SourcePack = null;
        protected ArrayList<RepaintInterface> observers;
        protected ArrayList<CardStack> WorkingStacks;
        protected ArrayList<CardDeck> Targetdecks;
        public static final int stackCount = 7;
        public static final int deckCount = 4;
        public static final String saveExtension = ".XXX";
        
        public CardBoard() {
	        this.Targetdecks = new ArrayList<>();
	        this.WorkingStacks = new ArrayList<>();
	        this.observers = new ArrayList<>();
	        AbstractFactorySolitaire Maker = new FactoryKlondike(); 
	        
	        this.SourcePack = Maker.createCardDeck();
	        this.SourcePack = RandomSwap(SourcePack);
	        
	        for (int i = 0; i < 7; i++)
	        {
	        	this.WorkingStacks.add(Maker.createWorkingPack());
	            for(int u = 0; u <= i; u++)
	            {
	            	if (u == i)
	            	{
	            		Card c = this.SourcePack.pop();
	            		c.turnFaceUp();
	            		this.WorkingStacks.get(i).InitPut(c);
	            	}
	            	else
	            		this.WorkingStacks.get(i).InitPut(this.SourcePack.pop());
	            }
	        }
	        
	        this.Targetdecks.add(Maker.createTargetPack(Card.Color.DIAMONDS));
	        this.Targetdecks.add(Maker.createTargetPack(Card.Color.HEARTS));
	        this.Targetdecks.add(Maker.createTargetPack(Card.Color.SPADES));
	        this.Targetdecks.add(Maker.createTargetPack(Card.Color.CLUBS));
        }
    
		@Override
		public CardStack getSourcePack() {
			// TODO Auto-generated method stub
			return null;
		}
		
        public void registerObserver(RepaintInterface repaintInterface) {
        	;// TODO Auto-generated method stub
        }
        
        public CardDeck GetSourceDeck()
        {
            return this.SourcePack;
        }
        
        public CardDeck getDeck(int index)
        {
        	return this.Targetdecks.get(index);
        }
        
        public CardStack getStack(int index)
        {
        	return this.WorkingStacks.get(index);
        }
        
        public boolean LoadGame ()
        {
            return true;
        }
        
        public boolean SaveGame ()
        {
            return true;
        }
        
        public CardDeck RandomSwap(CardDeck Deck)
        {
            Random NumberGenerator = new Random();
            for (int i = 0; i < 52; i++)
            {
                int RandomCard = NumberGenerator.nextInt(51);
                Collections.swap(Deck.karty, i, RandomCard);
            }
            return Deck;
        }
}
