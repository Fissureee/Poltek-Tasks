/**
 * array
 */
import java.util.Scanner;
public class array {
    public static void main(String[] args) {
        int[] Score = arrIn();
        for (int i : Score){
            System.out.println(i);
        }
        System.out.printf("The average is %d",countAverage(Score));
    }

    public static int[] arrIn(){
        Scanner input = new Scanner(System.in);
        int[] score = new int[10];
        for (int i = 0; i < score.length; i++) {
            System.out.printf("Input the score for student %d : ", i);
            score[i] = input.nextInt();
        }
        input.close();
        return score;
    }

    public static int countAverage(int... score){
        int average = 0;
        for (int i : score){
            average += i;
        }
        return average / score.length;
    }
}