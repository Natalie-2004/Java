package revision.event;

public interface Event {
    public Long getTimeStamp();
    public void process();
}
