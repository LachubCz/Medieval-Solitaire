
import ija.ija2016.homework3.controller.CommandInterface;
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

    public void execute(){
        if(this.canExecute()) {
            stack.showNext();
        }

    }

    public void unexecute(){
        stack.hideTopCard();
    }

    public boolean canExecute(){
        return !this.stack.isStackEmpty();
    }
}