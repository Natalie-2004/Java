package observer.numberConvertor;

// step 3: create observer instance
public class BinaryObserver extends Observer {
    public Subject subject;
    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Binary String: "
        + Integer.toBinaryString(subject.getState())
        );
    }
}
