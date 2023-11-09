public class Square {
    int side;

    public Square(int side) {
        this.side = side;
    }

    public void print_side() {
        System.out.println("Side: " + side);
    }

    public void print_area() {
        System.out.println("Area: " + (side * side));
    }

    public void print_perimeter() {
        System.out.println("Perimeter: " + (4 * side));
    }
}
