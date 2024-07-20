package observer.numberConvertor;

import java.util.ArrayList;
import java.util.List;

// step 1: create class subject
public class Subject {
    private List<Observer> observers = new ArrayList<Observer>();
    private int state;

    // get current state
    public int getState() {
        return state;
    }

    // update new state: i.e new item arrived on store
    public void setState(int state) {
        this.state = state;
        // notify certain customer
        notifyAllObservers();
    }

    // 
    public void attach(Observer observer) {
        observers.add(observer);
    }

    // certain customer that subscribe the store for this product
    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
