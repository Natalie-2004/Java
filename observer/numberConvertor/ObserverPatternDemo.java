package observer.numberConvertor;

// use subject and instance observer object
public class ObserverPatternDemo {
    public static void main(String[] args) {
        // initialised store
        Subject subject = new Subject();

        // people A B C that subscribed the store
        new HexaObserver(subject);
        new BinaryObserver(subject);
        new OctualObserver(subject);

        // whenever there's new item on store, its state changed
        // all people will get notify
        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);
    }
}
