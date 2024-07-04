package state;

class ErrorState implements PrinterState {
    @Override
    public void print(PrinterContext context) {
        System.out.println("Cannot print. Printer is in error state.");
    }

    @Override
    public void error(PrinterContext context) {
        System.out.println("Printer is already in error state.");
    }

    @Override
    public void reset(PrinterContext context) {
        context.setState(new IdleState());
        System.out.println("Printer reset to idle state.");
    }
}