package ija.ija2016.homework3.view;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainView extends JFrame{

	public static final int BOARD_LIMIT = 4;
	protected ArrayList<VisuallBoard> boards = new ArrayList<VisualBoard>();
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
		
	}

	protected void addBoard() {
		// TODO Auto-generated method stub
		
	}
}
