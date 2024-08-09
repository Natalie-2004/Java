package strategy.payment;

// step 2: create concrete method
public class CreditCardPayment implements PaymentStrategy{
    @Override
    public void processPayment() {
        System.out.println("Processing credit card payment...");
    }
}
