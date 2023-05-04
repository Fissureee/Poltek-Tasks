/**
 * Decending
 */
public class Decending {


    static void iterative(int n) {
        for (int i = n; i >= 0; i--){
            System.out.println(i);
        }
    }

    static void recursive(int n) {
        System.out.println(n);
        if (n > 0) {
            recursive(n -1);
        }
    }

    public static void main(String[] args) {
        iterative(5);
        recursive(5);
    }
}