package Reverse;

public class ReverseMain {
    public static void main(String[] args) {
        String s = "Politeknik Negeri Malang";
        ReverseStack stack = new ReverseStack(s.length());
        for (int i = 0; i < s.length(); i++){
            stack.push(s.charAt(i));
        }
        stack.print();
    }
}
