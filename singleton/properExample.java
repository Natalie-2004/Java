package singleton;

// eager instantiation
public class properExample {
    private properExample uniquInstnace = new properExample();

    private properExample() {

    }

    public properExample getUniqueInstance() {
        return uniquInstnace;
    }
}
