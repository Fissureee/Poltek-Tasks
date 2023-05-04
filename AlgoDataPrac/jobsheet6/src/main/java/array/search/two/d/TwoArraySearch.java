package array.search.two.d;

import java.sql.SQLOutput;
import java.util.Scanner;

public class TwoArraySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rowIdx , colIdx = 0;
        int[][] data = {
                {45, 78, 7, 200, 80},
                {90, 1, 17, 100, 50},
                {21, 2, 40, 18, 65}
        };

        System.out.print("Input search number: ");
        int search = sc.nextInt();

        for (int[] row : data){
            rowIdx = 0;
            for (int col : row){
                if (col == search){
                    System.out.printf("Number %d is found in row %d and column %d", search, rowIdx, colIdx);
                    break;
                }
                rowIdx++;
            }
            colIdx++;
        }
    }
}
