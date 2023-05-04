import java.util.Scanner;

public class Experiment2 {
    static int calculatePower(int x, int y) {
       
        if (y == 0) {
            
            return (1);
        } else {
            
            return (x * calculatePower(x, y - 1));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        System.out.print("Enter the exponent: ");
        int exponent = sc.nextInt();
        sc.close();
        System.out.println(calculatePower(number, exponent));
    }
}
