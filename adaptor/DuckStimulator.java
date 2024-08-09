package adaptor;

public class DuckStimulator {
    public static void main(String[] args) {
        Drone drone = new SuperDrone();
        Duck duck = new DroneAdaptor(drone);
        testDuck(duck);
    }

    static void testDuck(Duck duck) {
        duck.quack();
        duck.fly();
    }
}
