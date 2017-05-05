package ija.ija2016.homework3.controller;

import ija.ija2016.homework3.model.cards.CardBoard;
import ija.ija2016.homework3.model.cards.CardBoardInterface;
import java.util.ArrayList;

public class CommandBuilder {
        public static final String saveExtension = ".XXX";
        CardBoardInterface cardBoard = null;
        ArrayList<CommandInterface> undoStack;
        ArrayList<CommandInterface> redoStack;

    public CommandBuilder(CardBoard newCardBoard) {
        this.undoStack = new ArrayList<>();
        this.redoStack = new ArrayList<>();
        this.cardBoard = newCardBoard;
    }

    public void execute(CommandInterface command) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
