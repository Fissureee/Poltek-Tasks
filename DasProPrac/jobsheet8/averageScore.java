/**
 * averageScore
 */
import java.util.Scanner;
public class averageScore {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int student = sc.nextInt();
        int[] score = new int[student];
        double total = 0;
        double average;

        for (int i = 0; i < score.length; i++){
            System.out.print("Enter student score " + (i + 1) + ": ");
            score[i] = sc.nextInt();
        }

        for (int i = 0; i < score.length; i++) {
            total += score[i];
        }
        sc.close();
        average = total / score.length;
        System.out.println("The class average score is " + average);
    }
}