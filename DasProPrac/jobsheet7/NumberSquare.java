import java.util.Scanner;
public class NumberSquare {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the box size: ");
        int n = in.nextInt();

        for (int i = 0; i < n; i++){
            if (i == 0 || i == n-1) {
                for(int j = 0; j < n; j++){
                    System.out.print(n + " ");
                }
            } else {
                for(int j = 0; j < n; j++){
                    if (j == 0 || j == n-1){
                        System.out.print(n + " ");
                    } else {
                        System.out.print("  ");
                    }
                }
            }
            System.out.println("");
        }
    }
}