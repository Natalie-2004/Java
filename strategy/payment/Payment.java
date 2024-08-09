package strategy.payment;

// public class Payment {
//     public void processPayment(String type) {
//         if (type.equals("credit")) {
//             System.out.println("Processing credit card payment...");
//             // Credit card payment logic
//         } else if (type.equals("paypal")) {
//             System.out.println("Processing PayPal payment...");
//             // PayPal payment logic
//         } else {
//             System.out.println("Invalid payment type.");
//         }
//     }
// }

// this design have bad smell:
    // violates Open close principle by Adding a new payment method requires modifying the Payment class
    // use conditional logic to select the payment method

// At first, we create interface called PaymentStrategy to hold processPayment method
// then, implement concrete strategies for each payment method
// at last, modify this class to adapt strategy

// step 3: create class that create new interface and hold a class to execute
public class Payment {
    private PaymentStrategy strategy;

    public Payment(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public PaymentStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    // so then each payment method is encapsulated in its own class
    // switching payment methods is done by changing the strategy at runtime, 
    // avoiding conditional statements.
    public void processPayment() {
        strategy.processPayment();
    }
}

