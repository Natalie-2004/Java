package observer.binocthex;

public class OctualObserver extends Observer {
    public OctualObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Octual String: "
        + Integer.toBinaryString(subject.getState())
        );
    }
}
