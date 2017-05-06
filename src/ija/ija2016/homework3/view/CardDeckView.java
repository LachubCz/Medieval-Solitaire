package ija.ija2016.homework3.view;

import ija.ija2016.homework3.controller.CommandInterface;
import ija.ija2016.homework3.controller.CommandMove;
import ija.ija2016.homework3.model.cards.Card;
import ija.ija2016.homework3.model.cards.CardDeck;
import ija.ija2016.homework3.model.cards.CardStack;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CardDeckView {

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

    public CardView top() {
        return this.card;
    }
    
    public void setModel(CardDeck newDeck) {
        deck = newDeck;
    }

    void paint() {
        CardView cardView;
        Card stackCard = deck.top();
        
        CardView card = this.card = stackCard != null ?
	new CardView(CardView.CardViewColor.ColorView(stackCard.color()), stackCard.value(), x, y ) :
	new CardView(CardView.CardViewColor.NONE, 0, x, y );
	board.add(this.card);	
			
	card.addMouseListener(new MouseAdapter() {  
		public void mouseReleased(MouseEvent e)  
		    {  
			if(board.isSourceDeckorStackSelected()){
                            CommandInterface command;
                            CardDeck source = board.getSelectedSourceDeck();
                            if(source == null) {
                                CardStack sourceStack = board.getSelectedSourceStack();
                                command = new CommandMove(sourceStack, deck);
                            }
                            else {
                                command = new CommandMove(source, deck);
                            }
                            if(command.canExecute()) {
                                board.getCommandBuilder().execute(command);
                                board.unselectSelectedSource();
                            }
                            else if(!deck.isEmpty())  {
                                board.setSelectedSource(deck, null, card);
                            }
			}		
			else if(!deck.isEmpty()) {
                            board.setSelectedSource(deck, null, card);
                        }
		    }
		}); 
    }

}
