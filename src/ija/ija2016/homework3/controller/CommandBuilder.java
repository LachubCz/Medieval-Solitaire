package ija.ija2016.homework3.controller;

import ija.ija2016.homework3.model.cards.Card;
import ija.ija2016.homework3.model.cards.CardBoard;
import ija.ija2016.homework3.model.cards.CardBoardInterface;
import ija.ija2016.homework3.model.cards.CardDeck;
import ija.ija2016.homework3.model.cards.CardStack;

import java.util.ArrayList;

public class CommandBuilder {
        public static final String saveExtension = ".XXXXXX";
        CardBoardInterface cardBoard = null;
        ArrayList<CommandInterface> undoStack;

    public CommandBuilder(CardBoard newCardBoard) {
        this.undoStack = new ArrayList<>();
        this.cardBoard = newCardBoard;
    }

    public void execute(CommandInterface command) {
    	if(command.canExecute())
    	{
            command.execute();
            this.push(command);
            this.cardBoard.update();
        }
    }

    private void push(CommandInterface command){
        this.undoStack.add(command);
    }

    private CommandInterface pop(ArrayList<CommandInterface> stack){
    	if(!undoStack.isEmpty())
    		return undoStack.remove(undoStack.size() - 1);
    	return null;
    }
    
    public boolean undo(){
        if(!undoStack.isEmpty()){
        	CommandInterface command = this.pop(undoStack);
            command.unexecute();
            return true;
        }
        return false;
    }
    
    public void move(CardDeck source, CardDeck destination){
        this.execute(new CommandMove(source, destination));
    }
    
    public void move(CardStack source, CardDeck destination){
        this.execute(new CommandMove(source, destination));
    }
    
    public void move(CardStack source, CardStack destination){
        this.execute(new CommandMove(source, destination));
    }
    
    public void move(CardDeck source, CardStack destination){
        this.execute(new CommandMove(source, destination));
    }
    
    public void next(CardStack stack){
    	this.execute(new CommandNext(stack));
    }
    
    public void renew(CardStack source){
    	this.execute(new CommandRenew(source));
    }
    
    public void movemultiple(CardStack source, CardStack destination, Card card){
    	this.execute(new CommandMoveMultiple(source, destination, card));
    }
}
	
