import java.util.Scanner;

public class DisplayNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input n: ");
        int n = sc.nextInt();

        int evenNum = 0;
        int count = 0;
        do {
            if (evenNum % 2 == 0) {
                if (evenNum % 4 != 0) {
                    System.out.printf("%d ", evenNum);
                    count++;
                }
            }
            evenNum++;
        } while (count < n);
    }
}