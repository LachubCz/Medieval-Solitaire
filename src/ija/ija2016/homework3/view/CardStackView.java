package ija.ija2016.homework3.view;

import ija.ija2016.homework3.model.cards.CardDeck;
import ija.ija2016.homework3.model.cards.CardStack;

public class CardStackView {
    public int x;
    public int y;
    BoardView board;
    CardStack stack;
    CardView topCard;

    public void setXY(int newX, int newY) {
	x = newX;
	y = newY;
    }
    
    public void setPanel(BoardView newBoard) {
	board = newBoard;
    }
    
    public void setModel(CardStack newStack) {
        stack = newStack;
    }

    void paint() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
