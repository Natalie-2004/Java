package revision.contact;

public class Contact {
    private String name;
    private PhoneNumber phoneNumber;
    private String emailAddress;

    public Contact(String name, PhoneNumber phoneNumber, String emailAddress) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public Contact(String name, PhoneNumber phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Contact(String name, String emailAddress) {
        this.name = name;
        this.emailAddress = emailAddress;
    }

    public static void main(String[] args) {
        Contact contact1 = new Contact("nn", "0416789");
        Contact contact2 = new Contact("n1", new PhoneNumber(12, "46378643784"));
        Contact contact3 = new Contact("n2", new PhoneNumber("463746327463"));
        Contact contact4 = new Contact("n2",
        new PhoneNumber("463746327463"), "1103@gmail.com");

        System.out.println(contact1);
        System.out.println(contact2);
        System.out.println(contact3);
        System.out.println(contact4);
    }
}
