package ija.ija2016.homework3.view;

import ija.ija2016.homework3.model.cards.Card;
import ija.ija2016.homework3.model.cards.CardDeck;

public class CardDeckView {

    static Object getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    static CardView top() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public int x,y;
    public BoardView board;
    private CardView card;
    CardDeck deck;

    public void setXY(int newX, int newY) {
	x = newX;
	y = newY;
    }

    public void setPanel(BoardView newBoard) {
	board = newBoard;
    }

    void paint() {
        CardView cardView;
        Card stackCard = deck.top();
        
        if(stackCard != null) {
            cardView = new CardView(CardView.CardViewColor.ColorView(stackCard.color()), stackCard.value(), x, y);
        }
    }

    void setModel(CardDeck newDeck) {
        deck = newDeck;
    }

}
