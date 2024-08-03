package revision.banking;

public class Bank {
    public static void main(String[] args) {
        BankaAccount a1 = new BankaAccount("A", 100.00);
        a1.withdraw(50.00);
        System.out.println("current balance: " + a1.getBalance());
    }
}
