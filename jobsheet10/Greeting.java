/**
 * Greeting
 */
public class Greeting {

    static void giveGreeting(){
        System.out.println("Hello! Good morning");
    }
    
    static void saySometing(String expression) {
        System.out.print(expression);
    }

    public static void main(String[] args) {
        giveGreeting();
        String exp = "Welcome to Java Programming";
        saySometing(exp);
    }
}