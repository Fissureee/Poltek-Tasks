import java.util.Scanner;

public class CalculateAreas {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String redo;
        do {
            System.out.println("Calculate Area Menu");
            System.out.print("1. Triangle \n2. Rectangle \n3. Circle \n4. Exit \nInput your option: ");
            int menu = sc.nextInt();
            switch (menu) {
                case 1:
                    areaTriangle();
                    break;
                case 2:
                    areaRectangle();
                    break;
                case 3:
                    areaCircle();
                    break;
                default:
                    System.out.println();
                    break;
            }
            System.out.print("Count again? ");
            redo = sc.next();
        } while(redo.equals("y"));

    }

    public static void areaTriangle(){
        System.out.print("Input base: ");
        int base = sc.nextInt();
        System.out.print("Input height: ");
        int height = sc.nextInt();

        System.out.printf("The area of the triangle is %d \n",( base * height)/2 );
    }
    public static void areaRectangle(){
        System.out.print("Input length: ");
        int length = sc.nextInt();
        System.out.print("Input width: ");
        int width = sc.nextInt();

        System.out.printf("The area of the rectangle is %d \n",(length * width));
    }
    public static void areaCircle(){
        System.out.print("Input radius: ");
        int radius = sc.nextInt();

        System.out.printf("The are of the circle is %-2f \n",(Math.PI * (radius * radius)));
    }
}