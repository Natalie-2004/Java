package singleton;

// lazy instantiation
// in this case the uniquInstnace variable is delayed its instantiate.
// benefit: if not using this class it would not instantiate uniquInstnace

// note this is multithread unsafe but a good example for singleton pattern
// if multithreads enter if (uniquInstnace == null) { and in this time uniquInstnace is null
// then there will be multiple thread undergoing uniquInstnace = new easyExample();, once again,
// instantiate uniquInstnace multiply times
public class EasyExample {
    private EasyExample uniquInstnace;

    private EasyExample() {

    }

    // when the first time to get uniquInstnace, since it is null it will be initialised once
    // then at next time since it is no longer null it directly return to uniquInstnace
    public EasyExample getUniqueInstance() {
        if (uniquInstnace == null) {
            uniquInstnace = new EasyExample();
        }
        return uniquInstnace;
    }
}
