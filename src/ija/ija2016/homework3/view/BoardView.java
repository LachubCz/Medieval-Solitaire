package ija.ija2016.homework3.view;
import ija.ija2016.homework3.controller.CommandInterface;
import java.util.ArrayList;
import javax.swing.JPanel;
import ija.ija2016.homework3.controller.CommandBuilder;
import ija.ija2016.homework3.controller.CommandControl;
import ija.ija2016.homework3.model.cards.Card;
import ija.ija2016.homework3.model.cards.CardBoard;
import ija.ija2016.homework3.model.cards.CardBoardInterface;
import ija.ija2016.homework3.model.cards.CardDeck;
import ija.ija2016.homework3.model.cards.CardHint;
import ija.ija2016.homework3.model.cards.CardStack;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import ija.ija2016.homework3.model.cards.PleaseRepaint;
import java.io.FilenameFilter;
import javax.swing.ImageIcon;
import javax.swing.JLabel;



public class BoardView extends JPanel implements PleaseRepaint {
 
	private CardDeck selectedSourceDeck = null;
        private CardStack selectedSourceStack = null;
	private Card selectedMultipleCard = null;

        private CardView selectedSourceCard = null;

	private static final long serialVersionUID = 1L;

	private CommandBuilder commander;
	private CardBoardInterface cardBoard;
	private CardDecknSourceView mainCardPicker; //standard deck and source

	private ArrayList<CardDeckView> decks = new ArrayList<>(); //target pack
	private ArrayList<CardStackView> stacks = new ArrayList<>(); //working pack

        private boolean hintNeeded = false;
        

	public BoardView(CardBoard newCardBoard) {
		commander = new CommandBuilder(newCardBoard);
		this.setLayout(null);
		cardBoard = newCardBoard;
		newCardBoard.registerObserver((PleaseRepaint)this);
                this.CreateAll();
	}

	private void CreateAll() {
                JButton buttonSave = new JButton("Save");
                buttonSave.setBounds(0, 0, 80, 25);
                buttonSave.setBackground(Color.ORANGE);
                buttonSave.setForeground(Color.BLACK);
                this.add(buttonSave);
                
		JButton buttonUndo = new JButton("Undo");
                buttonUndo.setBounds(80, 0, 80, 25);
                buttonUndo.setBackground(Color.ORANGE);
                buttonUndo.setForeground(Color.BLACK);
                this.add(buttonUndo);

                JButton buttonLoad = new JButton("Load");
                buttonLoad.setBounds(160, 0, 80, 25);
                buttonLoad.setBackground(Color.ORANGE);
                buttonLoad.setForeground(Color.BLACK);
                this.add(buttonLoad);
                
                JButton buttonClose = new JButton("Close");
                buttonClose.setBounds(240, 0, 80, 25);
                buttonClose.setBackground(Color.ORANGE);
                buttonClose.setForeground(Color.BLACK);
                this.add(buttonClose);
                
                JButton buttonHint;
                if(hintNeeded) {
                    buttonHint = new JButton("Hint On");
                }
                else {
                    buttonHint = new JButton("Hint Off");
                }
                buttonHint.setBounds(320, 0, 80, 25);
                buttonHint.setBackground(Color.ORANGE);
                buttonHint.setForeground(Color.BLACK);
                this.add(buttonHint);
                
                
                int basicValue = this.getHeight();
 

                
                int cardSpace = (int)(basicValue / 4.6);
                
                CardDecknSourceView packPicker = new CardDecknSourceView();
                packPicker.setModel(cardBoard.getSourcePack());
                packPicker.setXY(cardSpace * (1), 30);
                packPicker.setPanel(this);
                packPicker.paint();
                
                mainCardPicker = packPicker;
                
                for(int i = 0; i < 7; i++) {
                    CardStackView stack = new CardStackView();
                    stack.setModel(cardBoard.getStack(i));
                    stack.setXY(cardSpace * (i+1), (int)(basicValue / 2.70 )  );
                    stack.setPanel(this);
                    stack.paint();
                    stacks.add(stack);
		}
                
                for(int i = 0; i < 4; i++) {
                    CardDeckView deck = new CardDeckView();
                    deck.setModel(cardBoard.getDeck(i));
                    deck.setXY(cardSpace * (i+4), 30);
                    deck.setPanel(this);
                    deck.paint();
                    decks.add(deck);
		}
                
                buttonSave.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        String fileName = JOptionPane.showInputDialog(null, "Enter file name:", "Dialog for file name", JOptionPane.WARNING_MESSAGE);
		        if(fileName.length() > 0){
		        	CommandInterface command = new CommandControl("save", new ArrayList<String>(){{add("saves/" + fileName);}});
		        	commander.execute(command);
		        }
		    }
		});

                

                buttonHint.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	if(hintNeeded) {
                            hintNeeded = false;
                            buttonHint.setText("Hint Off");
                        }
                        else {
                            hintNeeded = true;
                            buttonHint.setText("Hint On");
                            setSelectedSource(selectedSourceDeck, selectedSourceStack, selectedSourceCard);
                        }
		    }
		});
                
		buttonUndo.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	CommandInterface command = new CommandControl("undo");
		    	commander.execute(command);
		    }
		});
                
                buttonLoad.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        loadFile();
		    }
		});

                buttonClose.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
		    	closeThisBoard();
		    }
		});
	}
        
        @Override
        public void repaint() {
            removeComponents();
            this.removeAll();
            
            if(this.cardBoard != null) {
                if(this.cardBoard.isGameOver()) {
                     CreateGameOver();
                }
                else {
                    this.CreateAll();
                }
            }
            super.repaint();
            this.revalidate();
        }
        
        public void CreateGameOver(){
            JButton buttonClose= new JButton("Game Over");
            buttonClose.setBounds(400, 200, 200, 200);
            buttonClose.setBackground(Color.ORANGE);
            buttonClose.setForeground(Color.BLACK);
            this.add(buttonClose); 
            
		buttonClose.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	closeThisBoard();
		    }
		});
	}
        
        public void loadFile() {
 
            
		File[] FileList = new File("saves").listFiles((File dir, String filename) -> filename.endsWith(".XXX"));
                
		if(FileList == null) {
                    JOptionPane.showMessageDialog(null, "There are no saved games in the saves folder.", "Error finding saved games.", JOptionPane.INFORMATION_MESSAGE);
                    return;
		}
                
                String[] fileString = new String[FileList.length];
                
                int i = 0;
		for (File file : FileList) {
                   fileString[i] = file.getName().replaceAll("\\.XXX$", "");
                   i++;
		}		
		
                /*
                public static Object showInputDialog(Component parentComponent,
                     Object message,
                     String title,
                     int messageType,
                     Icon icon,
                     Object[] selectionValues,
                     Object initialSelectionValue)
                */
                
                Object[] fileNamesArray = new Object[fileString.length];
		fileNamesArray = (Object[])fileString;
                
		String fileToLoad = (String)JOptionPane.showInputDialog(
		                    this,
		                    "Select Game you want to play",
		                    "Load game",
		                    JOptionPane.PLAIN_MESSAGE,
		                    null,
		                    fileNamesArray,
		                    "loadDialog");

		if (fileToLoad != null) {
			CommandInterface command = new CommandControl("load", new ArrayList<String>(){{add("saves/" + fileToLoad);}});
			this.getCommandBuilder().execute(command);
		}
        }
        
        public void closeThisBoard() {
            MainView mainWindow = (MainView)this.getTopLevelAncestor();
            mainWindow.removeBoard(this);
        }
        
        private void removeComponents() {
            Component [] components = this.getComponents();
            for(Component component: components) {
                MouseListener[] listeners = component.getMouseListeners();
                for(MouseListener listener: listeners) {
                    this.removeMouseListener(listener);
                }
            }
        }

        public CommandBuilder getCommandBuilder() {
            return this.commander;
        }
        
        public CardDeck getSelectedSourceDeck() {
            return this.selectedSourceDeck;
        }
        
        public CardStack getSelectedSourceStack() {
            return this.selectedSourceStack;
        }
        
        public void setSelectedSource(CardDeck deck, CardStack stack) {
            this.selectedSourceDeck = deck;
            this.selectedSourceStack = stack;
        }
        
        public void setSelectedSource(CardDeck deck, CardStack stack,  CardView sourceCard) {
            if(this.selectedSourceCard != null) {
                this.selectedSourceCard.setSelected(false);
            }
            this.selectedSourceStack = stack;
            this.selectedSourceDeck = deck;
            this.selectedSourceCard = sourceCard;
            this.setSelectedtMultipleMoveCard(null);
            
		if(sourceCard != null){
		sourceCard.setSelected(true);
                    if(this.hintNeeded) {
                        this.createHints();
                    }
		}
        }
        
        public void unselectSelectedSource(){
            this.setSelectedSource(null, null, null);
	}
        
        public boolean isSourceDeckorStackSelected() {
            return this.selectedSourceDeck != null || this.selectedSourceStack != null;
        }
        
        public Card getSelectedtMultipleMoveCard(){
            return this.selectedMultipleCard;
	}
        
	public void setSelectedtMultipleMoveCard(Card card) {
            this.selectedMultipleCard = card;
	}
        
        
        public void createHints() {
            int hint = this.cardBoard.createHint(this.selectedSourceCard.toCard());
            URL url = LayoutVisualization.class.getResource("/ija/textures/background.png");
           // ImageIcon icon = createImageIcon(url);
            //JLabel label1 = new JLabel("Image and Text",
            //        icon,
            //        JLabel.CENTER);
            //label1.setVerticalTextPosition(JLabel.BOTTOM);
            //label1.setHorizontalTextPosition(JLabel.CENTER);
            //this.add(label1);
        
            if(hint == -1)
            {
                System.out.println("Nic jsem nenasel");
                return;
            }
        
            if(hint < 10)
            {
        	CardDeckView deck = this.decks.get(hint);
                System.out.println("I found something on target deck number " + (hint+1));
                CardView card = deck.top();
                card.setHint(true);
                this.getCommandBuilder().Update();
            }
            else
            {
        	//hint = cislo workingpacku
        	hint = hint - 10;
                CardStackView stack = this.stacks.get(hint);
                System.out.println("I found something on working stack number " + (hint+1));
                CardView card = stack.top();
                card.setHint(true);
            }
	}
        
        
        @Override
        protected void paintComponent(final Graphics g) {
            super.paintComponent(g);
            Image image = null;
            try {
                URL url = LayoutVisualization.class.getResource("/ija/textures/background.png");
                image = ImageIO.read(url);
            } catch (IOException ex) {
                Logger.getLogger(BoardView.class.getName()).log(Level.SEVERE, null, ex);
            }
            g.drawImage(image, 0, 0, null);
        }

    private ImageIcon createImageIcon(String imagesmiddlegif) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

