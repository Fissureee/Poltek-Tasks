public class borrowMain {
    public static void main(String[] args) {
        borrowing borrow = new borrowing(1, "Sum1", "The End");
        borrow.calculate_bill(2, 5000);
        borrow.print_data();
    }
}
