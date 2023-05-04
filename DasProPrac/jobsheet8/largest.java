/**
 * largest
 */
import java.util.Scanner;
public class largest {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of array elements: ");
        int size = input.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.printf("Enter the value of element %d: ", (i + 1));
            array[i] = input.nextInt();
        }
        input.close();
        int large = 0;
        for (int i = 0; i < array.length; i++){
            large = (array[i] > large) ? array[i] : large;
        }
        System.out.println("The largest number is " + large);
    }
}