package ija.ija2016.homework3.view;

import ija.ija2016.homework3.model.cards.Card;
import ija.ija2016.homework3.model.cards.CardDeck;
import ija.ija2016.homework3.model.cards.CardStack;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
    
    public CardView top() {
        return this.topCard;
    }

    void paint() {
        int distance;
        if(LayoutVisualization.get().isLayoutChanged()) {
            distance = 15;
        }
        else {
            distance = 30;
        }
        
        
        for(int index = stack.size() - 1; index >= 0; index--) {
            Card card = stack.get(index);
            CardView cardView;
            
            if(card.isTurnedFaceUp()) {
                cardView = new CardView(CardView.CardViewColor.ColorView(card.color()), card.value(), x, y + distance * index);
            }
            else {
                cardView = new CardView(CardView.CardViewColor.BACK, 0, x, y + distance * index);
            }
            board.add(cardView);
            
            if(index == stack.size() - 1 ) {
		cardView.addMouseListener(new MouseAdapter() {  
                    public void mouseReleased(MouseEvent e) {  
                            moveStackHere(cardView);
                    }  
		});
            this.topCard = cardView;
            }
            else {
                if(card.isTurnedFaceUp()) {
                    cardView.addMouseListener(new MouseAdapter() {  
                        public void mouseReleased(MouseEvent e) {  
                            board.setSelectedSourceDeck(stack.getDeck(), cardView);
                            board.setMultiMoveCard(card);
                        }  
                    });
                }
            }
        }

    }
    
    public void moveStackHere(CardView card) {
        
    }
}
