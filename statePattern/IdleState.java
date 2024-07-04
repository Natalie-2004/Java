package statePattern;

class IdleState implements PrinterState {
    @Override
    public void print(PrinterContext context) {
        System.out.println("Printing...");
        context.setState(new PrintingState());
    }

    @Override
    public void error(PrinterContext context) {
        context.setState(new ErrorState());
        System.out.println("Printer is in error state.");
    }

    @Override
    public void reset(PrinterContext context) {
        System.out.println("Printer is already in idle state.");
    }
}
