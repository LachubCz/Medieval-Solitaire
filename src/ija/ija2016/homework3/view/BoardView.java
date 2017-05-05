package ija.ija2016.homework3.view;

import ija.ija2016.homework3.controller.CommandInterface;
import java.util.ArrayList;

import javax.swing.JPanel;

import ija.ija2016.homework3.model.cards.RepaintInterface;
import ija.ija2016.homework3.controller.CommandBuilder;
import ija.ija2016.homework3.controller.CommandControl;
import ija.ija2016.homework3.model.cards.Card;
import ija.ija2016.homework3.model.cards.CardBoard;
import ija.ija2016.homework3.model.cards.CardBoardInterface;
import ija.ija2016.homework3.model.cards.CardDeck;
import ija.ija2016.homework3.model.cards.CardDeckInterface;
import ija.ija2016.homework3.model.cards.CardInterface;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class BoardView extends JPanel implements RepaintInterface {
	private CardDeck selectedSource;
	private Card selectedCard;
	
	
	private static final long serialVersionUID = 1L;
	private CommandBuilder commander;
	private CardBoardInterface cardBoard;
	
	private ArrayList<CardDeckView> decks = new ArrayList<>(); //target pack
	private ArrayList<CardStackView> stacks = new ArrayList<>(); //working pack
	private CardPackView mainCardPicker; //standard deck

	

	public BoardView(CardBoard newCardBoard) {
		commander = new CommandBuilder(newCardBoard);
		this.setLayout(null);
		cardBoard = newCardBoard;
		newCardBoard.registerObserver((RepaintInterface)this);
		this.CreateAll();
		
	}



	private void CreateAll() {
                JButton buttonSave = new JButton("Save");
                buttonSave.setBounds(0, 0, 80, 25);
                this.add(buttonSave);
            
		JButton buttonUndo = new JButton("Undo");
                buttonUndo.setBounds(80, 0, 80, 25);
                this.add(buttonUndo);
                
                JButton buttonLoad = new JButton("Load");
                buttonLoad.setBounds(160, 0, 80, 25);
                this.add(buttonLoad);
                
                JButton buttonClose = new JButton("Close");
                buttonClose.setBounds(240, 0, 80, 25);
                this.add(buttonClose);
                
                
                int basicValue = this.getHeight();
                
                int cardSpace = (int)(basicValue / 4.4);
                
                CardPackView packPicker = new CardPackView();
                packPicker.setModel(cardBoard.getSourcePack());
                packPicker.setXY(cardSpace * (1), 35);
                packPicker.setPanel(this);
                packPicker.paint();
                mainCardPicker = packPicker;
                
                
                for(int i = 0; i < 7; i++) {
			CardStackView stack = new CardStackView();
			stack.setModel(cardBoard.getStack(i));
			stack.setXY(cardSpace * (i+1), (int)(basicValue / 2.4 )  );
			stack.setPanel(this);
			stack.paint();
			stacks.add(stack);
		}
                
                
                for(int i = 0; i < 4; i++) {
			CardDeckView deck = new CardDeckView();
			deck.setModel(cardBoard.getDeck(i));
			deck.setXY(cardSpace * (i+4), /*(basicValue / 20)*/ 35  );
			deck.setPanel(this);
			deck.paint();
			decks.add(deck);
		}
                
                //add event handlers
		buttonUndo.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	CommandInterface command = new CommandControl("undo");
		    	getCommandBuilder().execute(command);
		    }
		});
		//add event handlers
		btnSave.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        String fileName = JOptionPane.showInputDialog(null, "Enter file name:", "Dialog for file name", JOptionPane.WARNING_MESSAGE);
		        if(fileName.length() > 0){
		        	ICommand command = new ControlCommand("save", new ArrayList<String>(){{add(fileName);}});
		        	getCommandBuilder().execute(command);
		        }
		    	
		    	
		    }
		});
		//add event handlers
		btnLoad.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        loadFile();
		    }
		});
		//add event handlers
		btnClose.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        //your actions
		    	closeThisBoard();
		    }
		});
                
                
                
                
                
                
		
	}

}
