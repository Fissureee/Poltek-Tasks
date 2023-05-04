import java.util.Scanner;
public class sumOf {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int number, i, sum = 0, length = 0, num = 0;
        float avg;

        System.out.print("Enter a number range: ");
        number = input.nextInt();

        System.out.printf("The number of even numbers from 1 to %d is %d\n", number, (number/2));
        for (i = 1; i <= number; i++){
            if (i % 2 != 0){
                continue;
            }
            num ++;
            sum += i;
            System.out.printf("Even number %d is %d\n", num, i);
        }
        avg = sum / num;
        System.out.printf("The sum of the even numbers from 1 to %d is %d\n", number, sum);
        System.out.printf("The average of the even numbers from 1 to %d is %.2f\n", number, avg);
        
    }
}