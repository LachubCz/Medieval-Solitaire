/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ija.ija2016.homework3.view;

import ija.ija2016.homework3.model.cards.CardStack;

/**
 *
 * @author Holajz
 */
class CardPackView {
    public int x,y;
    public BoardView board;
    public String name;
    
    private CardStack pack; //source pack
    
    public void setXY(int newX, int newY) {
	x = newX;
	y = newY;
    }

    public void setPanel(BoardView newBoard) {
        board = newBoard;
    }
    
    public String getName(){
	return this.name;
    } 
    
    public void setName(String name){
        this.name = name;
    }
    
    void setModel(CardStack sourcePack) {
        this.pack = sourcePack;
    }
    
    void paint() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
