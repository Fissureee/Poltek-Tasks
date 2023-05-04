/**
 * Circle
 */
public class Circle {

    public static void main(String[] args) {
        System.out.println(circumference(12));
        System.out.println(area(12));
    }

    public static Double circumference(int r){
        return 2 * 3.14 * r;
    }

    public static Double area(int r2){
        return 3.14 * (r2*r2);
    }
}