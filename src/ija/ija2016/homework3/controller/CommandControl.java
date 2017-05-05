/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ija.ija2016.homework3.controller;

import java.util.ArrayList;

/**
 *
 * @author Holajz
 */
public class CommandControl implements CommandInterface{
    private String calling = null;
    private ArrayList<String> arguments = null;

        public CommandControl(String calling) {
            this.calling = calling;
        }
    
    public CommandControl(String calling, ArrayList<String> arguments) {
        this.calling = calling;
        this.arguments = arguments;
    }


    public void execute() {
        
    }

 
    public void unexecute() {
        
    }


    public boolean canExecute() {
        return true;
    }
    
    public String getCall() {
        return this.calling;
    }
    
    public int argumentsCount() {
        if(this.arguments != null) {
            return this.arguments.size();
        }
        return 0;
    }
    
    public boolean hasArguments() {
        if(this.argumentsCount() > 0) {
            return true;
        }
        return false;
    }
    
    public ArrayList<String> getArguments() {
        return this.arguments;
    }
    
    

}
