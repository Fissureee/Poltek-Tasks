import java.util.Scanner;
public class restaurant {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        String food;
        int price, delivery, total, express;

        System.out.print("Enter a food name: ");
        food = input.nextLine();
        System.out.print("Enter the food price: IDR ");
        price = input.nextInt();
        System.out.print("Do you want express delivery (0 = no, 1 = yes) ? ");
        express = input.nextInt();

        // if (price < 100000) {
        //     delivery = 20000;
        //     if (express == 1) {
        //         delivery += 25000;
        //     }
        // } else {
        //     delivery = 30000;
        //     if (express == 1) {
        //         delivery += 25000;
        //     }
        // }

        delivery = (price < 100000) ? (express == 1) ? 45000 : 20000 : (express == 1) ? 55000 : 30000;
        total = price + delivery;

        System.out.println(
        "RECEIPT\n" + 
        food + "\tIDR " + price +
        "\nShipping costs" + "\tRp " + delivery +
        "\nTOTAL" + "\t\tRp " +total
        );
    }
}