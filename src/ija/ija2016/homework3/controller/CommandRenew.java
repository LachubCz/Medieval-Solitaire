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
    ArrayList<Card> cards= null;

    public CommandRenew(CardStack source){
        this.stack = source;
    }

    @Override
    public void execute(){
        if(this.canExecute()){
            cards= new ArrayList<>();
            for(int index = 0; index < stack.size(); index++)
                cards.add(stack.get(index));
            stack.turnOver();
        }       
    }

    @Override
    public void unexecute(){
        while(!stack.isSourceEmpty())
            stack.showNext();
        while(stack.size() > 0)
            stack.pop();
        while(stack.size() > 0)
            stack.emplace(cards.remove(0));
    }

    @Override
    public boolean canExecute(){
        return !this.stack.isSourceEmpty();
    }
}
