package Banking;

import java.util.Scanner;

public class MenuFunction {
    public void addAccount(AccountStack accStack){
        Scanner in = new Scanner(System.in);
        char loop;
        do {
            System.out.println("\n========== Input ==========");
            System.out.print("Account Number: ");
            String accNum = in.nextLine();

            System.out.print("Name: ");
            String name = in.nextLine();

            System.out.print("Phone Number: ");
            String phone = in.nextLine();

            System.out.print("Email: ");
            String email = in.nextLine();

            System.out.print("Initial Balance: ");
            int initBalance = in.nextInt();

            Account newData = new Account(accNum, name, phone, email, initBalance);
            accStack.push(newData);

            System.out.print("Add another account(y/n)? ");
            loop = in.next().charAt(0);
            in.nextLine();
        } while (loop == 'y' && !accStack.isFull());
    }

}
