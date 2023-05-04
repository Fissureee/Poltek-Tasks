import java.util.Scanner;
public class ReverseStar {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input the size of the triangle: ");
        int n = input.nextInt();
        
        for (int i = n; i >= 0; i--){
            for (int j = 0; j  < i; j++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}