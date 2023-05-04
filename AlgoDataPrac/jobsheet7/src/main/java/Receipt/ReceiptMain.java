package Receipt;

import java.util.Scanner;

public class ReceiptMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input the number of receipt: ");
        int size = sc.nextInt();
        ReceiptStack stack = new ReceiptStack(size);
        for (int i = 0; i < size; i++){
            System.out.print("Transaction ID: ");
            String id = sc.next();

            System.out.print("Date: ");
            int date = sc.nextInt();

            System.out.print("Quantity of items: ");
            int qty = sc.nextInt();

            System.out.print("Total price: ");
            int price = sc.nextInt();

            Receipt newTrans = new Receipt(id, date, qty, price);
            stack.push(newTrans);
        }
        stack.print();
    }
}
