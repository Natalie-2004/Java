package strategy.payment;

public class PayPalPayment implements PaymentStrategy {
    @Override
    public void processPayment() {
        System.out.println("Processing pay pal payment...");
    }
}
