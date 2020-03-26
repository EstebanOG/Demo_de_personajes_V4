/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer;

/**
 *
 * @author Juan
 */
public class Subject extends Observable{
    private int State;

    public int getState() {
        return State;
    }

    public void setState(int State) {
        this.State = State;
        this.notifyObservers();
    }
    
    
}
