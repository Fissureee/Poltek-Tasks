import java.util.Scanner;
public class triangle {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        float side1, side2, side3;

        System.out.print("Input first side: ");
        side1 = input.nextFloat();
        System.out.print("Input second side: ");
        side2 = input.nextFloat();
        System.out.print("Input third side: ");
        side3 = input.nextFloat();

        if (side1 == side2 && side2 == side3){
            System.out.println("This triangle is Equilateral");
        } else if (side1 == side2 || side2 == side3 || side1 == side3){
            System.out.println("This triangle is Isosceles");
        } else {
            System.out.println("This triangle is Arbitary");
        }
    }
}