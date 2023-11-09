package VaccineQueue;

import java.util.Scanner;

public class QueueMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QueueLinkedList qll = new QueueLinkedList();
        int menu;
        do {
            System.out.println(
                "+++++++++++++++++++++++++++\n" +
                "Extravaganza Vaccine Queue\n" +
                "+++++++++++++++++++++++++++\n" +
                "1. Add Vaccine queue\n" +
                "2. Remove Vaccine queue\n" +
                "3. Display Vaccine queue\n" +
                "4. Exit\n" +
                "+++++++++++++++++++++++++++"
            );
            menu = sc.nextInt();
            sc.nextLine();
            switch (menu){
                case 1:
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Number: ");
                    String number = sc.nextLine();
                    qll.add(number, name);
                    break;
                case 2:
                    qll.remove();
                    break;
                case 3:
                    qll.print();
                    break;
            }
        } while(menu > 0 && menu < 4);

    }
}
