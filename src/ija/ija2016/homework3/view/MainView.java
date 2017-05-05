package ija.ija2016.homework3.view;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ija.ija2016.homework3.model.cards.CardBoard;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Icon;

public class MainView extends JFrame{


	private static final long serialVersionUID = 1L;
	
	public static final int BOARD_LIMIT = 4;
	protected ArrayList<BoardView> boards = new ArrayList<>();
	private JPanel mainPanel;
	private GridLayout layoutFull;
	private GridLayout layout4Tiles;
        boolean stopPlayback = false;
        public JButton stopButton;
        private final String path;
        private static Clip clip;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
                        @Override
			public void run() {
				MainView frame = null;
                            try {
                                frame = new MainView();
                            } catch (LineUnavailableException ex) {
                                Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IOException ex) {
                                Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (UnsupportedAudioFileException ex) {
                                Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
                            }
				frame.setVisible(true);
				frame.addBoard();
			}
		});
	}
	
	public MainView() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		super("Medieval Klondike");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 700);
		getContentPane().setLayout(null);
		
		layoutFull = new GridLayout(1,1,0,0);
		layout4Tiles = new GridLayout(2,2,0,0);
		
		JPanel topP = new JPanel(layoutFull);
		topP.setBounds(0, 0, 1280, 25);
		
		JPanel mainP = new JPanel(layoutFull);
		mainP.setBounds(0, 25, 1280, 660);
		
		getContentPane().add(topP);
		getContentPane().add(mainP);
		
		this.mainPanel = mainP;
		
		JButton NewGameButton = new JButton("New Game");
                NewGameButton.setBounds(0, 0, 1000, 25);
                NewGameButton.setBackground(Color.ORANGE);
                NewGameButton.setForeground(Color.BLACK);
		topP.add(NewGameButton);
		
		NewGameButton.addActionListener(new ActionListener() {
			@Override
			//button click
			public void actionPerformed(ActionEvent e) {
				addBoard();
			}
		});
                

                
                stopButton = new JButton("Mute Music");
                stopButton.setBounds(0, 0, 140, 25);
                stopButton.setBackground(Color.ORANGE);
                stopButton.setForeground(Color.BLACK);
		topP.add(stopButton);
                
                path = "/ija/music/m1.wav";
                music(path);
                
                		
		
		stopButton.addActionListener(new ActionListener() {
			@Override
			//button click
			public void actionPerformed(ActionEvent e) {
                            String buttonText = (stopButton.getText());
                            
                            if(buttonText.equals("Unmute Music")) {
                                stopPlayback = false;
                                stopButton.setText("Mute Music");
                                clip.loop(Clip.LOOP_CONTINUOUSLY); 
                            }
                            else {
                                stopPlayback = true;
                                stopButton.setText("Unmute Music");
                                clip.stop();
                                
                            }

			}
		});
                
                
	}



	public void addBoard() {
		if(boards.size() < BOARD_LIMIT) {
			if(boards.size() == 1) {
				this.changeView(layout4Tiles);
			}
		}
		if(boards.size() == BOARD_LIMIT) {
                    return;
                }
		//creates template board
		CardBoard cardBoard = new CardBoard();
		//creates view of the board
		BoardView boardView = new BoardView(cardBoard);
		//adds to view
		this.mainPanel.add(boardView);
		//adds to boards view list
		boards.add(boardView);
		
		this.DoRepainting();
	}
	
	public void removeBoard(BoardView board) {
		if(boards.size() == 2) {
			//changes to full layout
			this.changeView(layoutFull);
		}
		
		//remove from the boards view list
		boards.remove(board);
		//remove from the view
		board.removeAll();
		this.mainPanel.remove(board);
		
		this.DoRepainting();
	}
	
	

	public void DoRepainting() {
		//repaint GUI
		this.repaint();
		this.revalidate();
		
	}

	public void changeView(GridLayout layout) {
		this.mainPanel.setLayout(layout);
		
		//je treba zmenit velikost karet, boardy apod.
		//LayoutVisualization.get().setUsingMiniatures((layout == this.layout4Tiles));
	}
        
        public static void music(String file) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        
        URL url = MainView.class.getResource(file);
        
        clip = AudioSystem.getClip();
        AudioInputStream inputStream = AudioSystem.getAudioInputStream(url);
        clip.open(inputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY); 
    

        }
    
}
