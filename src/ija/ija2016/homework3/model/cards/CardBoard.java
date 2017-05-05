package ija.ija2016.homework3.model.cards;

import ija.ija2016.homework3.model.board.AbstractFactorySolitaire;
import ija.ija2016.homework3.model.board.FactoryKlondike;
import java.util.ArrayList;

public class CardBoard implements CardBoardInterface{
        private AbstractFactorySolitaire factory;
    
        protected CardStack SourcePack = null;
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
        this.factory = new FactoryKlondike(); 
        
        
        
        
            
        }
    

	public void registerObserver(RepaintInterface repaintInterface) {
		// TODO Auto-generated method stub
		
	}
        
        public CardStack getSourcePack(){
            return this.SourcePack;
        }

        public CardDeck getDeck(int index) {
            return this.Targetdecks.get(index);
        }

        public CardStack getStack(int index) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public boolean isGameOver() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

}
