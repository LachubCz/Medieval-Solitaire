package ija.ija2016.homework3.controller;


import ija.ija2016.homework3.model.cards.CardStack;

/**
 *
 * @author Holajz
 */

public class CommandNext implements CommandInterface{
    CardStack stack = null;

    public CommandNext(CardStack stack){
        this.stack = stack;
    }

    @Override
    public void execute(){
        if(this.canExecute()) {
            stack.showNext();
        }

    }

    @Override
    public void unexecute(){
        stack.hideTopCard();
    }

    @Override
    public boolean canExecute(){
        return !this.stack.isEmpty();
    }
}
