/**
 * arrayInputLoop
 */
import java.util.Scanner;
public class arrayInputLoop {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] finalScore = new int[6];
        for (int i = 0; i < finalScore.length; i++){
            System.out.print("Enter the final score " + i + ": ");
            finalScore[i] = sc.nextInt();
        }
        sc.close();
        for (int i = 0; i < 6; i++){
            System.out.println("Student " + i + (finalScore[i] > 70 ? " Passed" : " Failed"));
        }
    }
}