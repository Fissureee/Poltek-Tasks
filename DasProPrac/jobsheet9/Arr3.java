/**
 * Arr3
 */
import java.util.Scanner;
public class Arr3 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int rows = input.nextInt();
        System.out.print("Enter the number of columns: ");
        int columns = input.nextInt();

        int[][] number = new int[rows][columns];
        for (int i = 0; i < number.length; i++){
            for (int j = 0; j < number[0].length; j++){
                System.out.print("Enter a number [" + i + "][" + j + "]: ");
                number[i][j] = input.nextInt();
            }
            System.out.println("----------------");
        }
        input.close();
        for (int array[] : number) {
            for (int r : array) {
                System.out.print(r + " ");
            }
            System.out.println();
        }
    }
}