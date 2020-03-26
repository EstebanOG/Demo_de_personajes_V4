
package observer;

import java.util.ArrayList;

 //* @author Juan

public class Observable{
    private static ArrayList<Observer> observadores = new ArrayList<Observer>();
    
    public void add(Observer a){
        observadores.add(a);
    }
    public void del(Observer a){
        observadores.remove(a);
    }
    public void notifyObservers(){
        for (int i = 0; i < observadores.size(); i++) {
            observadores.get(i).Update();
        }
    }
}
