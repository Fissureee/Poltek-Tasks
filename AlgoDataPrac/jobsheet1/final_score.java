import java.util.Scanner;
/**
 * final_score
 */
public class final_score {

    public static void main(String[] args) {
        showResult();
    }

    public static Double scoreInput(){
        Scanner sc = new Scanner(System.in);
        Double score;

        do{
            System.out.print("Input assignment score: ");
            score = sc.nextDouble() / 100 * 20;
            System.out.print("Input midterm score: ");
            score += sc.nextDouble() / 100 * 35;
            System.out.print("Input final score: ");
            score += sc.nextDouble() / 100 * 45;
            sc.close();
        }while(score > 100 || score < 0);
        
        return score;
    }

    public static void showResult(){
        Double score = scoreInput();
        String grade ;

        if(score > 80 && score <= 100){
            grade = "A";
        }else if(score > 73 && score <= 80){
            grade = "B+";
        }else if(score > 65 && score <= 73){
            grade = "B";
        }else if(score > 60 && score <= 65){
            grade = "C+";
        }else if(score > 50 && score <= 60){
            grade = "C";
        }else if(score > 39 && score <= 50){
            grade = "D";
        }else{
            grade = "E";
        }
        System.out.println("Final Score: " + score);
        System.out.println("Alphabet Score: " + grade);
        graduate(grade);
    }

    public static void graduate(String alphabet){
        String isGraduate = (
            alphabet.equals("A") || 
            alphabet.equals("B+") || 
            alphabet.equals("B") || 
            alphabet.equals("C+") || 
            alphabet.equals("C")
            ) ? "You Graduated" : "You didn't Graduate";
        System.out.println(isGraduate);
    }
}