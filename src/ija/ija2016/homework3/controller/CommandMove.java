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
                if(destination != null && source != null)
                {
                    this.destination.put(source.pop());
                    if(!this.source.isEmpty()) {
                        this.isTurnedUp = this.source.top().isTurnedFaceUp();
                        this.source.top().turnFaceUp();
                    }
                }
                if(destinationStack != null && sourceStack != null)
                {
                    this.destinationStack.put(sourceStack.pop());
                    if(!this.sourceStack.isEmpty()) {
                        this.isTurnedUp = this.sourceStack.top().isTurnedFaceUp();
                        this.sourceStack.top().turnFaceUp();
                    }
                }
                if(destination != null && sourceStack != null)
                {
                    this.destination.put(sourceStack.pop());
                    if(!this.sourceStack.isEmpty()) {
                        this.isTurnedUp = this.sourceStack.top().isTurnedFaceUp();
                        this.sourceStack.top().turnFaceUp();
                    }
                }
                if(destinationStack != null && source != null)
                {
                    this.destinationStack.put(source.pop());
                    if(!this.source.isEmpty()) {
                        this.isTurnedUp = this.source.top().isTurnedFaceUp();
                        this.source.top().turnFaceUp();
                    }
                }
            }
    }

    public void unexecute() {
        if(!this.isTurnedUp) {
        	if(this.source != null)
        		this.source.top().turnFaceDown();
        	if(this.sourceStack != null)
        		this.sourceStack.top().turnFaceDown();
        }
        if(this.source != null)
        {
        	if(this.destination != null)
        	{
        		this.source.emplace(this.destination.pop());
        	}
        	if(this.destinationStack != null)
        	{
        		this.source.emplace(this.destinationStack.pop());
        	}
        }
        if(this.sourceStack != null)
        {
        	if(this.destination != null)
        	{
        		this.sourceStack.InitPut(this.destination.pop());
        	}
        	if(this.destinationStack != null)
        	{
        		this.sourceStack.InitPut(this.destinationStack.pop());
        	}
        }
    }

    public boolean canExecute() {
    	if (destination != null)
    	{
    		if(source != null)
    		{
                if(!destination.canPut(source.top())) {
                    return false;
                }
                return true;
    		}
    		if(sourceStack != null)
    		{
                if(!destination.canPut(sourceStack.top())) {
                    return false;
                }
                return true;
    		}
    	}
    	if (destinationStack != null)
    	{
    		if(source != null)
    		{
                if(!destinationStack.canPutCard(source.top())) {
                    return false;
                }
                return true;
    		}
    		if(sourceStack != null)
    		{
                if(!destinationStack.canPutCard(sourceStack.top())) {
                    return false;
                }
                return true;
    		}
    	}
    	return false;
    }
}
