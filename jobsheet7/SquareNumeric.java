import java.util.Scanner;
public class SquareNumeric {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int n = in.nextInt();
        if (n < 5){
            return;
        } else {
            for (int i = 1; i <= n; i++){
                if (i % 2 == 0) {
                    for ( int j = n; j > 0; j--){
                        System.out.print(j);
                    }
                } else {
                    for (int j = 1; j <= n; j++){
                        System.out.print(j);
                    }
                }
                
                System.out.println("");
            }
        }
    }
}