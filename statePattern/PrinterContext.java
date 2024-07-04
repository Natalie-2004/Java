package statePattern;

public class PrinterContext {
    private PrinterState state;

    public PrinterContext() {
        state = new IdleState(); // Initial state
    }

    public void setState(PrinterState state) {
        this.state = state;
    }

    public void print() {
        state.print(this);
    }

    public void error() {
        state.error(this);
    }

    public void reset() {
        state.reset(this);
    }
}
