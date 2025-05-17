
import java.util.Scanner;

public class sumofdigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        int sum = 0;

        do {
            sum += number % 10;
            number /= 10;
        } while (number > 0);

        System.out.println("Sum of digits: " + sum);
    }
}