package observer.numberConvertor;

public class OctualObserver extends Observer {
    public Subject subject;
    public OctualObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Octual String: "
        + Integer.toOctalString(subject.getState())
        );
    }
}
