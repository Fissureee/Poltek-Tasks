public class Factorial {

    static int factor(int n) {
        if (n == 0){
            return (0);
        } else {
            return(n + factor(n - 1));
        }
    }

    public static void main(String[] args) {
        System.out.println(factor(8));
    }
}