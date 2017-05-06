/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ija.ija2016.homework3.view;

import ija.ija2016.homework3.controller.CommandInterface;
import ija.ija2016.homework3.controller.CommandNext;
import ija.ija2016.homework3.controller.CommandRenew;
import ija.ija2016.homework3.model.cards.Card;
import ija.ija2016.homework3.model.cards.CardStack;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Holajz
 */
class CardDecknSourceView {
    public int x,y;
    public BoardView board;
    public String name;
    
    private CardStack pack; //source pack
    private CardView picker;
    private CardView putAside;
    
    public void setXY(int newX, int newY) {
	x = newX;
	y = newY;
    }

    public void setPanel(BoardView newBoard) {
        board = newBoard;
    }
    
    public void setModel(CardStack sourcePack) {
        this.pack = sourcePack;
    }
    
    public void paint() {
        if(pack.isStackEmpty()) {
            CardView card = new CardView(CardView.CardViewColor.BACK, 0, 0, y  );
            board.add(card);
            picker = card;	
			
            card.addMouseListener(new MouseAdapter() {  
             public void mouseReleased(MouseEvent e) {  
                    CommandInterface command = new CommandNext(pack);
                    board.getCommandBuilder().execute(command);
		}  
            }); 
        }
        else {
            CardView card = new CardView(CardView.CardViewColor.NEW_DECK, 0, 0, y  );
            board.add(card);
            picker = card;
            
            card.addMouseListener(new MouseAdapter() {  
            public void mouseReleased(MouseEvent e) {  
                    CommandInterface command = new CommandRenew(pack);
                    board.getCommandBuilder().execute(command);
		}  
            }); 
        }
        
        if(!pack.isEmpty()) {
            Card modelCard = pack.top();
            CardView card = new CardView(CardView.CardViewColor.ColorView(modelCard.color()), modelCard.value(), x, y  );
            board.add(card);
            putAside = card; 
			
            card.addMouseListener(new MouseAdapter() {  
		public void mouseReleased(MouseEvent e) {  
                    board.setSelectedSourceDeck(pack.getDeck(), card);
		}  
            }); 
        }
        else {
            CardView card = new CardView(CardView.CardViewColor.NONE, 0, x, y  );
            board.add(card);
            putAside = card;
        }
        
    }


    
}
