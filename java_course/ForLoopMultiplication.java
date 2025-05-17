import java.util.Scanner;

public class ForLoopMultiplication {
public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter any number");
   int j= sc.nextInt();
  // for(int i = 1; i<=10; i++){
   int i=1;
  while(i<=10){
         int Result=j*i;
        System.out.println(j+"x"+i+"="+Result);
i++;
    }
    sc.close();
}
}
    

