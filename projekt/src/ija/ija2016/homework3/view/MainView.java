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

public class MainView extends JFrame{


	private static final long serialVersionUID = 1L;
	
	public static final int BOARD_LIMIT = 4;
	protected ArrayList<BoardView> boards = new ArrayList<BoardView>();
	private JPanel bottomPanel;
	private GridLayout layoutFull;
	private GridLayout layout4Tiles;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				MainView frame = new MainView();
				frame.setVisible(true);
				frame.addBoard();
			}
		});
	}
	
	public MainView() {
		super("Medieval Klondike");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 700);
		getContentPane().setLayout(null);
		
		layoutFull = new GridLayout(1,1,0,0);
		layout4Tiles = new GridLayout(2,2,0,0);
		
		JPanel topPanel = new JPanel(layoutFull);
		topPanel.setBounds(0, 0, 1280, 25);
		
		JPanel mainPanel = new JPanel(layoutFull);
		mainPanel.setBounds(0, 25, 1280, 660);
		
		getContentPane().add(topPanel);
		getContentPane().add(mainPanel);
		
		this.bottomPanel = mainPanel;
		
		JButton NewGameButton = new JButton("New Game");
		topPanel.add(NewGameButton);
		
		NewGameButton.addActionListener(new ActionListener() {
			@Override
			//button click
			public void actionPerformed(ActionEvent e) {
				addBoard();
			}
		});
		
	}



	public void addBoard() {
		if(boards.size() < BOARD_LIMIT) {
			if(boards.size() == 1) {
				this.changeView(layout4Tiles);
			}
		}
		
		//creates template board
		CardBoard cardBoard = new CardBoard();
		//creates view of the board
		BoardView boardView = new BoardView(cardBoard);
		//adds to view
		this.bottomPanel.add(boardView);
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
		this.bottomPanel.remove(board);
		
		this.DoRepainting();
	}
	
	

	public void DoRepainting() {
		//repaint GUI
		this.repaint();
		this.revalidate();
		
	}

	public void changeView(GridLayout layout) {
		this.bottomPanel.setLayout(layout);
		
		//je treba zmenit velikost karet, boardy apod.
		LayoutVisualization.get().setUsingMiniatures((layout == this.layout4Tiles));
	}
}
