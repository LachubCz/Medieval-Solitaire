/*
 * @author Tom� Hol�k, xholik13
 * @author Petr Buchal, xbucha02
 * @version 0.3
 * Projekt: Medieval Klondike
 * System: Windows 10
 * University: Brno University of Technology
 * Course: IJA
 */
package ija.ija2016.homework3.model.cards;

import java.util.ArrayList;

/**
 *
 * @author Holajz
 */
public class CardHint {
    private ArrayList<CardDeck>  decks  = new ArrayList<>();
    private ArrayList<CardStack> stacks = new ArrayList<>();
    private Card card = null;
    private CardDeck sourceDeck = null;
    
    public CardHint(Card card, CardDeck sourcedeck) {
        this.card = card;
        this.sourceDeck = sourceDeck;
    }
    

    public ArrayList<CardDeck> getCardDecks() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<CardStack> getCardStacks() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean add(CardStack stack) {
        return true;
    }
    
    public boolean add(CardDeck deck) {
        return true;
    }
    
}
