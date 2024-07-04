package state;

class PrintingState implements PrinterState {
    @Override
    public void print(PrinterContext context) {
        System.out.println("Already printing...");
    }

    @Override
    public void error(PrinterContext context) {
        context.setState(new ErrorState());
        System.out.println("Printer is in error state.");
    }

    @Override
    public void reset(PrinterContext context) {
        context.setState(new IdleState());
        System.out.println("Printer reset to idle state.");
    }
}
