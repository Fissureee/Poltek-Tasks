import java.util.Scanner;

/**
 * oddEven
 */
public class oddEven {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of array elements: ");
        int size = input.nextInt();
        int array[] =  new int[size];

        for (int i = 0; i < array.length; i++){
            System.out.printf("Enter the value of element %d: ", (i + 1));
            array[i] = input.nextInt();
        }
        input.close();
        for (int i : array) {
            System.out.printf(((i % 2 == 0) ? "Even number: %d \n" : ""), i);
        }
        for (int i : array) {
            System.out.printf(((i % 2 != 0) ? "Odd number: %d \n" : ""), i);
        }
    }
}