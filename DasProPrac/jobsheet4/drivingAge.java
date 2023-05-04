import java.util.Scanner;
public class drivingAge {
    public static void main(String args[]){
        int age;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your age: ");
        age = input.nextInt();

        System.out.println((age >= 17) ? "Allowed to drive" : "Not allowed to drive");
    }
}