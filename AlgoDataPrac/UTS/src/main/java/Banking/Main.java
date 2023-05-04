package Banking;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MenuFunction menu = new MenuFunction();

        System.out.print("Set data size: ");
        AccountStack accStack = new AccountStack(sc.nextInt());
        boolean menuLoop = true;
        do {
            System.out.println("========== Menu ==========");
            System.out.println("1. Add account \n2. Display account data \n3. Sort account data \n4. Display account with 0 balance \n5. Search account by name \n6. Withdraw \n7. Deposit");
            System.out.print("Input your selection: ");
            int selection = sc.nextInt();
            switch (selection){
                case 1 : menu.addAccount(accStack);
                    break;

                case 2 :
                    System.out.println("\n========== Data ==========");
                    accStack.print();
                    break;

                case 3 : accStack.sort();
                    break;

                case 4 : accStack.displayAcc0();
                    break;

                case 5 :
                    System.out.print("Input the acccount name: ");
                    sc.nextLine();
                    accStack.searchName(sc.nextLine());
                    break;

                case 6 :
                    System.out.print("Input name: ");
                    String name = sc.nextLine();
                    sc.nextLine();
                    System.out.print("Input value: ");
                    int value = sc.nextInt();
                    accStack.withdraw(name, value);
                    break;

                case 7 :
                    System.out.print("Input name: ");
                    String nm = sc.nextLine();
                    sc.nextLine();
                    System.out.print("Input value: ");
                    int val = sc.nextInt();
                    accStack.deposit(nm, val);
                    break;

                default: menuLoop = false;
            }
        } while (menuLoop);

    }
}