/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ija.ija2016.homework3.controller;

import ija.ija2016.homework3.model.cards.CardDeck;
import ija.ija2016.homework3.model.cards.CardStack;

/**
 *
 * @author Holajz
 */
public class CommandMove implements CommandInterface{
    CardDeck source = null;
    CardStack sourceStack = null;
    CardDeck destination = null;
    CardStack destinationStack = null;
    boolean isTurnedUp = false;
    
    
    public CommandMove(CardDeck source, CardDeck destination) {
        this.source = source;
        this.destination = destination;
    }
    
    public CommandMove(CardStack source, CardDeck destination) {
        this.sourceStack = source;
        this.destination = destination;
    }
    
    public CommandMove(CardStack source, CardStack destination) {
        this.sourceStack = source;
        this.destinationStack = destination;
    }
    
    public CommandMove(CardDeck source, CardStack destination) {
        this.source = source;
        this.destinationStack = destination;
    }

    public void execute() {
            if(this.canExecute()) {
                isTurnedUp = false;
                this.destination.put(source.pop());
                if(!this.source.isEmpty()) {
                    this.isTurnedUp = this.source.top().isTurnedFaceUp();
                    this.source.top().turnFaceUp();
                }
            }

    }

    public void unexecute() {
        if(!this.isTurnedUp) {
            this.source.top().turnFaceDown();
        }
        this.source.emplace(this.destination.pop());
    }

    public boolean canExecute() {
        if(!destination.canPut(source.top())) {
            return false;
        }
        return true;
    }
    
}
