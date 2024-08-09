package adaptor;

public class DroneAdaptor implements Duck {
    private Drone drone;

    public DroneAdaptor(Drone drone) {
        this.drone = drone;
    }

    @Override
    public void quack() {
        drone.beep();
    }

    @Override
    public void fly() {
       drone.spin_rotors();
       drone.take_off();
    }
    
}
