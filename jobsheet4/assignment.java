import java.util.Scanner;
public class assignment {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);

        int number1, number2, bigNumber;

        System.out.print("Enter number1: ");
        number1 = input.nextInt();
        System.out.print("Enter number2: ");
        number2 = input.nextInt();

        bigNumber = (number1 > number2) ? number1 : number2;

        System.out.println("The largest value is: " + bigNumber);
    }
}