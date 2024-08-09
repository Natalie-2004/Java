package adaptor;

public class SuperDrone implements Drone {

    @Override
    public void beep() {
        System.out.println("beep");
    }

    @Override
    public void spin_rotors() {
        System.out.println("spin_rotors");
    }

    @Override
    public void take_off() {
        System.out.println("take_off");
    }
    
}
