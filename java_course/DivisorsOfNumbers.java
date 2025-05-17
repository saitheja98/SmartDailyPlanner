
import java.util.Scanner;

public class DivisorsOfNumbers {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter your number");
    int num1=input.nextInt();
    for (int i=1; i<=num1; i++){
        if (num1%i==0){
            System.out.println(i);
        }

    }
    
}
}