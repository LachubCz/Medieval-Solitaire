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
import java.util.Random;

public class CardBoard implements CardBoardInterface {
        protected CardStack SourcePack = null;
        protected CardDeck StandardDeck = null;
        protected ArrayList<CardStack> WorkingStacks;
        protected ArrayList<CardDeck> Targetdecks;
        protected ArrayList<RepaintInterface> observers;
        public static final int stackCount = 7;
        public static final int deckCount = 4;
        public static final String saveExtension = ".XXX";
        
        public CardBoard() {
	        this.Targetdecks = new ArrayList<>();
	        this.WorkingStacks = new ArrayList<>();
	        this.observers = new ArrayList<>();
	        AbstractFactorySolitaire Maker = new FactoryKlondike(); 
	        
	        this.StandardDeck = Maker.createCardDeck();
	        this.SourcePack = Maker.createSourcePack();
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
	        
	        this.Targetdecks.add(Maker.createTargetPack(Card.Color.DIAMONDS));
	        this.Targetdecks.add(Maker.createTargetPack(Card.Color.HEARTS));
	        this.Targetdecks.add(Maker.createTargetPack(Card.Color.SPADES));
	        this.Targetdecks.add(Maker.createTargetPack(Card.Color.CLUBS));
        }
		
        public void registerObserver(RepaintInterface repaintInterface) 
        {
        	;// TODO Auto-generated method stub
        }
		
		public CardStack getSourcePack() {
        	return this.SourcePack;
		}
		
        public CardDeck getStandardDeck() 
		{
			return this.StandardDeck;
		}
        
        public CardDeck getDeck(int index)
        {
        	return this.Targetdecks.get(index);
        }
        
        public CardStack getStack(int index)
        {
        	return this.WorkingStacks.get(index);
        }
		
        public boolean isGameOver() {		
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.		
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
        	     this.Targetdecks = (ArrayList<CardDeck>)  ois.readObject();
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
	      	      oos.writeObject(this.Targetdecks);
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
}
