package statePattern;

public class Printer {

    private String state = "idle";

    public void print() {
        if (state.equals("idle")) {
            System.out.println("Printing...");
            state = "printing";
        } else if (state.equals("printing")) {
            System.out.println("Already printing...");
        } else if (state.equals("error")) {
            System.out.println("Cannot print. Printer is in error state.");
        }
    }

    public void error() {
        state = "error";
        System.out.println("Printer is in error state.");
    }

    public void reset() {
        state = "idle";
        System.out.println("Printer reset to idle state.");
    }
}

// this design have bad smell:
    // it violates open closed principle by adding new state requires modifying the Printer class
    // it uses conditional logic to handle state transitions and behaviors

// At first, we create interface called PaymentStrategy to hold each states
// and then, we have new class called PrinterContext