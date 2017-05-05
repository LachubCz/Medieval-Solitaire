/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ija.ija2016.homework3.model.board;


import ija.ija2016.homework3.model.cards.Card;
import ija.ija2016.homework3.model.cards.CardDeck;
import ija.ija2016.homework3.model.cards.CardStack;

import java.util.Collections;
import java.util.Random;

import ija.ija2016.homework3.model.board.FactoryKlondike;

public class GameBoard {
    public CardDeck SourceDeck;
    public CardDeck [] TargetDeck;
    public CardStack [] WorkingStack;
    
    public GameBoard()
    {
        FactoryKlondike Maker = new FactoryKlondike();
        this.SourceDeck = Maker.createCardDeck();
        SourceDeck = RandomSwap(SourceDeck);
        
        for (int i = 0; i < 7; i++)
        {
            WorkingStack[i] = Maker.createWorkingPack();
            for(int u = 0; u <= i; u++)
            {
                WorkingStack[i].put(SourceDeck.pop());
            }
        }
        
        TargetDeck[0] = Maker.createTargetPack(Card.Color.DIAMONDS);
        TargetDeck[1] = Maker.createTargetPack(Card.Color.HEARTS);
        TargetDeck[2] = Maker.createTargetPack(Card.Color.SPADES);
        TargetDeck[3] = Maker.createTargetPack(Card.Color.CLUBS);
    }
    
    public CardDeck GetTargetPack(int index)
    {
        return this.TargetDeck[index];
    }
    
    public CardStack GetWorkingStack(int index)
    {
        return this.WorkingStack[index];
    }
    
    public boolean LoadGame ()
    {
        return true;
    }
    
    public boolean SaveGame ()
    {
        return true;
    }
    
    public CardDeck RandomSwap(CardDeck Deck)
    {
        Random NumberGenerator = new Random();
        for (int i = 0; i < 52; i++)
        {
            int RandomCard = NumberGenerator.nextInt(51);
            //Collections.swap(Deck.karty, i, RandomCard);
        }
        return Deck;
    }
}
