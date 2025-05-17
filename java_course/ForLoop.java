import java.util.Scanner;

public class ForLoop {
public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter any number");
    int j= sc.nextInt();
    for(int i = 1; i<=j; i++){
         if(i%2==0){
            System.out.println(i);
         }
        

         sc.close();
    }
}
}
