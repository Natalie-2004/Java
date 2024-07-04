package state;

interface PrinterState {
    void print(PrinterContext context);
    void error(PrinterContext context);
    void reset(PrinterContext context);
}
