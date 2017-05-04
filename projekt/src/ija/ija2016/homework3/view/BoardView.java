package ija.ija2016.homework3.view;

import java.util.ArrayList;

import javax.swing.JPanel;

import ija.ija2016.homework3.model.cards.RepaintInterface;
import ija.ija2016.homework3.controller.CommandMaker;
import ija.ija2016.homework3.model.cards.Card;
import ija.ija2016.homework3.model.cards.CardBoard;
import ija.ija2016.homework3.model.cards.CardBoardInterface;
import ija.ija2016.homework3.model.cards.CardDeck;
import ija.ija2016.homework3.model.cards.CardDeckInterface;
import ija.ija2016.homework3.model.cards.CardInterface;

public class BoardView extends JPanel implements RepaintInterface {
	private CardDeck selectedSource;
	private Card selectedCard;
	
	
	private static final long serialVersionUID = 1L;
	private CommandMaker commander;
	private CardBoardInterface cardBoard;
	
	private ArrayList<CardDeckView> decks = new ArrayList<CardDeckView>(); //target pack
	private ArrayList<CardStackView> stacks = new ArrayList<CardStackView>(); //working pack
	private CardDeckView mainpack; //standard deck

	

	public BoardView(CardBoardInterface cardBoard) {
		// TODO Auto-generated constructor stub
	}

}
