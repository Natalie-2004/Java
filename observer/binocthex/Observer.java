package observer.binocthex;

// step 2: create Observer class
public abstract class Observer {
    public Subject subject;
    public abstract void update();
}
