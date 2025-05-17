import java.util.Scanner;

public class DoWhile {
    public static void main(String[] args){
    Scanner input = new Scanner(System.in);
   // System.out.println("Enter any number");
    int j= input.nextInt();
   //for(int i = 1; i<=10; i++){
   int i=1;
  while(i<=10){
         int Result=j*i;
        System.out.println(j +"x" +i +"="+ Result);
i++;
    }
    input.close();
}
}
    

