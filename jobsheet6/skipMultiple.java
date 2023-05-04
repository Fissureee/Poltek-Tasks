import java.util.Scanner;
public class skipMultiple {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int number, i;

        System.out.print("Enter a number: ");
        number = input.nextInt();

        for (i = 0; i <= number; i++){
            if (i % 5 == 0){
                continue;
            }
            System.out.println(i);
        }
    }
}