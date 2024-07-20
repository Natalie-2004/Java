package observer.numberConvertor;

// step 3: create observer instance
public class BinaryObserver extends Observer {
    public Subject subject;
    public BinaryObserver(Subject subject) {
        this.subject = subject;
        // the subsribed customer automatically added into the list of subscribers
        this.subject.attach(this);
    }

    // update is called whenever the store change its state
    @Override
    public void update() {
        System.out.println("Binary String: "
        + Integer.toBinaryString(subject.getState())
        );
    }
}
