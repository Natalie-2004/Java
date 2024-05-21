import java.util.Scanner;

// scan input numbers and add together
public class Sum {

    public static void main(String[] args) {
        // type variable name   class
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] numbers = line.split(" ");

        int total = 0;

        for (String number: numbers) {
            total += Integer.parseInt(number);
        }

        System.out.println(total);
    }
}