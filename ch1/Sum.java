import java.util.Scanner;

// scan input numbers and add together
public class Sum {

    public static void main(String[] args) {
        // type variable name   class
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        // given that we know the users enter input 
        // int num -> .nextInt
        // double num -> .nextDouble
        // bool -> .nextBoolean

        // hasNext -> determine whether uses give input
        // .hasNextLine(), .hasNextInt()... 
        String[] numbers = line.split(" ");

        int total = 0;

        for (String number: numbers) {
            total += Integer.parseInt(number);
        }

        System.out.println(total);

        scanner.close();
    }
}