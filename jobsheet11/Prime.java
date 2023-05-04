public class Prime {
    
    static boolean primary(int n, int i){
        if (n == 2 || (i * i > n)) return true;

        if (n < 2 || n % i == 0) return false;

        return primary(n, i + 1);
    }

    public static void main(String[] args) {
        System.out.println((primary(15, 2)) ? "Primary" : "Not primary");
    }
}
