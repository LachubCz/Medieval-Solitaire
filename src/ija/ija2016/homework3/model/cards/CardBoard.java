package ija.ija2016.homework3.model.cards;

import ija.ija2016.homework3.model.board.AbstractFactorySolitaire;
import ija.ija2016.homework3.model.board.FactoryKlondike;
import ija.ija2016.homework3.model.cards.CardDeck;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Random;

import org.junit.Assert;

public class CardBoard implements CardBoardInterface {
        private boolean gameOver = false;
        protected CardStack SourcePack = null;
        protected CardDeck StandardDeck = null;
        protected ArrayList<CardStack> WorkingStacks;
        protected ArrayList<CardDeck> TargetDecks;
        protected ArrayList<RepaintInterface> observers;
        public static final int stackCount = 7;
        public static final int deckCount = 4;
        public static final String saveExtension = ".XXX";
        private boolean game = true;
        
        public CardBoard() {
	        this.TargetDecks = new ArrayList<>();
	        this.WorkingStacks = new ArrayList<>();
	        this.observers = new ArrayList<>();
	        AbstractFactorySolitaire Maker = new FactoryKlondike(); 
	        
	        this.StandardDeck = Maker.createCardDeck();
            this.StandardDeck = RandomSwap(StandardDeck);
                
	        for (int i = 0; i < 7; i++)
	        {
	        	this.WorkingStacks.add(Maker.createWorkingPack());
	            for(int u = 0; u <= i; u++)
	            {
	            	if (u == i)
	            	{
	            		Card c = this.StandardDeck.pop();
	            		c.turnFaceUp();
	            		this.WorkingStacks.get(i).InitPut(c);
	            	}
	            	else
	            		this.WorkingStacks.get(i).InitPut(this.StandardDeck.pop());
	            }
	        }
	        
	        this.SourcePack = Maker.createSourcePack(StandardDeck);
	        
	        this.TargetDecks.add(Maker.createTargetPack(Card.Color.DIAMONDS));
	        this.TargetDecks.add(Maker.createTargetPack(Card.Color.HEARTS));
	        this.TargetDecks.add(Maker.createTargetPack(Card.Color.SPADES));
	        this.TargetDecks.add(Maker.createTargetPack(Card.Color.CLUBS));
	        
	        //debug pro multipresun
	        /*
	        this.WorkingStacks.get(0).pop();
	        this.WorkingStacks.get(0).InitPut(Maker.createCard(Card.Color.HEARTS, 2));
	        this.WorkingStacks.get(0).getFromStack(0).turnFaceUp();
	        this.WorkingStacks.get(0).InitPut(Maker.createCard(Card.Color.CLUBS, 1));
	        this.WorkingStacks.get(0).getFromStack(1).turnFaceUp();
	        this.WorkingStacks.get(1).pop();
	        this.WorkingStacks.get(1).pop();
	        this.WorkingStacks.get(1).InitPut(Maker.createCard(Card.Color.CLUBS, 3));
	        this.WorkingStacks.get(1).getFromStack(0).turnFaceUp();
	        */
        }
		
        public void registerObserver(RepaintInterface repaintInterface) 
        {
            observers.add(repaintInterface);
        }
        
	public CardStack getSourcePack() {
            return this.SourcePack;
	}
        
        public CardDeck getDeck(int index)
        {
        	return this.TargetDecks.get(index);
        }
        
        public CardStack getStack(int index)
        {
        	return this.WorkingStacks.get(index);
        }
		
        
        public boolean LoadGame (String filename)
        {
        	try 
        	{
        		 FileInputStream fin = new FileInputStream(filename + saveExtension);
        		 ObjectInputStream ois = new ObjectInputStream(fin);
        	     this.observers = (ArrayList<RepaintInterface>)  ois.readObject();
        	     this.StandardDeck = (CardDeck)  ois.readObject();
        	     this.SourcePack = (CardStack)  ois.readObject();
        	     this.WorkingStacks = (ArrayList<CardStack>)  ois.readObject();
        	     this.TargetDecks = (ArrayList<CardDeck>)  ois.readObject();
        		 fin.close();
        		 ois.close();
        	}
        	catch (Exception e)
        	{ 
        		e.printStackTrace();
        		return false;
        	}
            return true;
        }
        
        public boolean SaveGame (String filename)
        {
        	try 
        	{
	      	      FileOutputStream fout = new FileOutputStream(filename + saveExtension);
	      	      ObjectOutputStream oos = new ObjectOutputStream(fout);
	      	      oos.writeObject(this.observers);
	      	      oos.writeObject(this.StandardDeck);
	      	      oos.writeObject(this.SourcePack);
	      	      oos.writeObject(this.WorkingStacks);
	      	      oos.writeObject(this.TargetDecks);
	      	      fout.close();
	      	      oos.close();
      	    }
      	   	catch (Exception e) 
        	{	
      	   		 e.printStackTrace();
      	   		 return false;
      	   	}
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
        
        public int createHint(Card Card){
        	
        	CardHint hint = hintForCard(Card);
        	
        	if (!(hint.getCardDecks().isEmpty()))
        	{
                for (int i = 0; i < 4; i++)
                {
            		if (hint.getCardDeck(0).equals(this.getDeck(i)))
            		{
            			return i;
            		}
                }
        	}
        	
        	if (!(hint.getCardStacks().isEmpty()))
        	{
                for (int i = 0; i < 7; i++)
                {
            		if (hint.getCardStack(0).equals(this.getStack(i)))
            		{
            			return 10 + i;
            		}
                }
        	}
        	return -1;
        }

        public CardHint hintForCard(Card Card){
        	
        	CardHint hint = new CardHint();
        	
	        for (int i = 0; i < 7; i++)
	        {
	        	if (this.getStack(i).canPutCard(Card))
	        	{
	        		hint.add(this.getStack(i));
	        	}
	        }
	        
	        for (int i = 0; i < 4; i++)
	        {
	        	if (this.getDeck(i).canPutCard(Card))
	        	{
	        		hint.add(this.getDeck(i));
	        	}
	        }
	        
        	return hint;
        }
        
        @Override
	public void update() {
	    this.game = this.isGameOver();
            this.observers.forEach((observer) -> {
                observer.repaint();
            });
	}
		
	public boolean isGameOver()
	{
            for(int i = 0; i < 4; i++)
		{
                    if (this.getStack(i).size() != 13)
			return false;
                }
            return true;
	}


}
