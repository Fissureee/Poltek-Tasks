package StackDLL;

import java.util.Scanner;

public class StackMain {
    public static void main(String[] args) {
        StackLinkedList sll = new StackLinkedList();
        Scanner sc = new Scanner(System.in);
        int menu;
        do {
            System.out.println(
                    "*****************\n" +
                    "Library data book\n" +
                    "*****************\n" +
                    "1. Add new book\n" +
                    "2. Get book from top\n" +
                    "3. Peek book title from top\n" +
                    "4. Info all books\n" +
                    "5. Exit\n" +
                    "*****************"
            );
            menu = sc.nextInt();
            sc.nextLine();
            switch (menu){
                case 1:
                    System.out.print("Book Name: ");
                    sll.addFirst(sc.nextLine());
                    break;
                case 2:
                    sll.pop();
                    break;
                case 3:
                    sll.peek();
                    break;
                case 4:
                    sll.print();
                    break;
            }
        } while(menu > 0 && menu < 5);
    }
}
