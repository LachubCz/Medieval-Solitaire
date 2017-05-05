/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ija.ija2016.homework3.controller;

import java.io.Serializable;

/**
 *
 * @author Holajz
 */
public interface CommandInterface extends Serializable{
    
    public void execute();
    
    public void unexecute();
    
    public boolean canExecute();
    
}
