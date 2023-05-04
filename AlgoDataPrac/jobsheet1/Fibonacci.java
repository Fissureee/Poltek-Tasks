public class Fibonacci {
    public static void main(String[] args) {
        printFibonacciLoop(5);
        System.out.println();
        printFibonacciRecursive(5);
    }

    public static void printFibonacciLoop(int n) {
        int a = 0, b = 1, c;
        System.out.print(a + " " + b);
        for (int i = 2; i < n; i++) {
            c = a + b;
            System.out.print(" " + c);
            a = b;
            b = c;
        }
    }

    public static int fibonacciRecursive(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static void printFibonacciRecursive(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacciRecursive(i) + " ");
        }
    }

}