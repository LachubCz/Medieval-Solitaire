/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ija.ija2016.homework3.controller;

import ija.ija2016.homework3.model.cards.Card;
import ija.ija2016.homework3.model.cards.CardStack;

/**
 *
 * @author Holajz
 */
public class CommandMoveMultiple implements CommandInterface{
    CardStack source      = null;
    CardStack destination = null;
    Card card             = null;
    boolean wasTurnedUp    = false;

    public CommandMoveMultiple(CardStack source, CardStack destination, Card card){
        this.source = source;
        this.destination = destination;
        this.card = card;
    }

    public void execute(){
        if(this.canExecute()){
            wasTurnedUp = false;
            this.destination.put(this.source.pop(card));
            if(!this.source.isEmpty()){
                this.wasTurnedUp = this.source.topStack().isTurnedFaceUp();
                this.source.topStack().turnFaceUp();
            }
        }
    }

    public void unexecute(){
        if(!this.wasTurnedUp)
            this.source.topStack().turnFaceDown();
        CardStack takenDeck = this.destination.pop(card);
        for(int index = 0; index < takenDeck.size(); index++){
            this.source.emplace(takenDeck.get(index));
        }
    }

    public boolean canExecute(){
        return this.destination.canPutCard(this.card);
    }
}
