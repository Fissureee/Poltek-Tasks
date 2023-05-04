/**
 * reverseArray
 */
import java.util.Scanner;
public class reverseArray {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] array = new int[5];
        for (int i = 0; i < array.length; i++){
            System.out.printf("Enter the value of element %d: ", i);
            array[i] = input.nextInt();
        }
        input.close();
        for (int i = array.length-1; i >= 0; i--){
            System.out.printf("[%d]", array[i]);
        }
    }
}