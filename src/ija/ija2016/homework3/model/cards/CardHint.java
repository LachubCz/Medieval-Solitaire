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
    private ArrayList<CardDeck> decks  = new ArrayList<>();
    private ArrayList<CardStack> stacks = new ArrayList<>();
    
    public CardDeck getCardDeck(int i) {
        return this.decks.get(i);
    }

    public CardStack getCardStack(int i) {
    	return this.stacks.get(i);
    }
    
    public ArrayList<CardDeck> getCardDecks() {
        return this.decks;
    }

    public ArrayList<CardStack> getCardStacks() {
    	return this.stacks;
    }
    
    public boolean add(CardStack stack) {
        this.stacks.add(stack);
    	return true;
    }
    
    public boolean add(CardDeck deck) {
        this.decks.add(deck);
    	return true;
    }
    
}
