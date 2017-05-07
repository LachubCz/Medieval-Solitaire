/*
 * @author Tom� Hol�k, xholik13
 * @author Petr Buchal, xbucha02
 * @version 0.3
 * Projekt: Medieval Klondike
 * System: Windows 10
 * University: Brno University of Technology
 * Course: IJA
 */
package ija.ija2016.homework3.controller;

import ija.ija2016.homework3.model.cards.Card;
import ija.ija2016.homework3.model.cards.CardStack;
import java.util.ArrayList;

/**
 *
 * @author Holajz
 */
public class CommandRenew implements CommandInterface{
    CardStack stack = null;

    public CommandRenew(CardStack source){
        this.stack = source;
    }

    @Override
    public void execute(){
        if(this.canExecute()){
            stack.turnOver();
        }       
    }

    @Override
    public void unexecute(){
        while(!stack.isEmpty())
            stack.showNext();
    }

    @Override
    public boolean canExecute(){
        return this.stack.isEmpty();
    }
}
