// private can only be access by the class itself
public class Shouter {

    private String message;

    // constructor
    public Shouter(String message) {
        // binding focus
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String newMessage) {
        message = newMessage;
    }

    public String shout() {
        return message.toUpperCase();
    }

    public static void main(String[] args) {
        Shouter shouter = new Shouter("hello");
        System.out.println(shouter.getMessage());
        shouter.setMessage("i love java");
        System.out.println(shouter.getMessage());
        System.out.println(shouter.shout());
    }
}
