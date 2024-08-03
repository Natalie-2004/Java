package revision.banking;

public class BankaAccount {
    private String owner;
    private double balance;

    public BankaAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public void withdraw(double amountToWithDraw) {
        if (amountToWithDraw > this.getBalance()) {
            System.out.println("Amount to withdraw can't greater than the current amount");
        }
        double newVal = (this.getBalance() - amountToWithDraw);
        setBalance(newVal);
    }

    public void deposit(double amountToDeposit) {
        double newVal = (this.getBalance() + amountToDeposit);
        setBalance(newVal);
    }

    public String getOwner() {
        return owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    
}
