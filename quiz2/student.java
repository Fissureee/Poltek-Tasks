/**
 * student
 */
import java.util.Scanner;
public class student {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name[];
        String subName[];
        int score[][];
        int studentAvg[];
        int subAvg[];

        System.out.print("Insert the number of students: ");
        int students = sc.nextInt();
        name = new String[students];
        studentAvg = new int[students];

        for (int i = 0; i < students; i++){
            System.out.printf("Insert the name of the student %d: ", i);
            name[i] = sc.next();
        }

        System.out.print("Insert the number of subjects: ");
        int subjects = sc.nextInt();
        subName = new String[subjects];
        subAvg = new int[subjects];

        for (int i = 0; i < subjects; i++){
            System.out.printf("Insert the name of the subject %d: ", i);
            subName[i] = sc.next();
            System.out.println("");
        }

        score = new int[students][subjects];
        for (int i = 0; i < students; i++){
            System.out.println("Score for student " + name[i]);
            for (int j = 0; j < subjects; j++){
                System.out.print("Score for subject " + subName[j]);
                score[i][j] = sc.nextInt();
                System.out.println("");
            }
            System.out.println("");
        }
        
        for (int i = 0; i < students; i++){
            int stAvg = 0, sbAvg = 0;

            for (int j = 0; j< subjects; j++){
                stAvg += score[i][j];
                sbAvg += score[j][i];
            }
            studentAvg[i] = stAvg / subjects;
            subAvg[i] = sbAvg / students;
        }

        sc.close();

        for (String subs : subName){
            System.out.printf(" %s", subs);
        }
        System.out.println("");
        for (int i = 0; i < students; i++){
            System.out.print(name[i]);
            for (int j = 0; j < subjects; j++){
                System.out.printf(" %d", score[i][j]);
            }
            System.out.println(" " + studentAvg[i]);
        }
        for (int avg : subAvg) {
            System.out.printf(" %s", avg);
        }
    }
}