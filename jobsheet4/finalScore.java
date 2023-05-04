import java.util.Scanner;
public class finalScore {
    public static void main(String args[]){
        float midtermExam, quiz, assignment, finalExam, score;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter midterm exam score: ");
        midtermExam = input.nextFloat();
        System.out.print("Enter final exam score: ");
        finalExam = input.nextFloat();
        System.out.print("Enter quiz score: ");
        quiz = input.nextFloat();
        System.out.print("Enter assignment score: ");
        assignment = input.nextFloat();
        

        score = 
        (midtermExam * 30 / 100) +
        (finalExam * 40 / 100) + 
        (quiz * 10 / 100) + 
        (assignment * 20 / 100);

        System.out.println((score < 65) ? "You'll get a remedy" : "You pass");
    }
}