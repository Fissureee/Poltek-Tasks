package DataManipulation;

import java.util.Scanner;

public class DoubleLInkedListMain {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        DoubleLinkedList dll = new DoubleLinkedList();
        int menu;
        do {
            System.out.println(
                    "==========================================\n" +
                    "Data Manipulation with Double Linked List\n" +
                    "==========================================\n" +
                    "1. Add First\n" +
                    "2. Add Tail\n" +
                    "3. Add Data in with Nth Index\n" +
                    "4. Remove First\n" +
                    "5. Remove Last\n" +
                    "6. Remove Data by Index\n" +
                    "7. Print\n" +
                    "8. Search Data\n" +
                    "9. Sort Data\n" +
                    "10. Exit\n" +
                    "=========================================="
            );
            menu = sc.nextInt();
            int item;
            switch (menu){
                case 1:
                    System.out.print("Insert Data: ");
                    dll.addFirst(sc.nextInt());
                    break;
                case 2:
                    System.out.print("Insert Data: ");
                    dll.addLast(sc.nextInt());
                    break;
                case 3:
                    System.out.print("Insert Data: ");
                    int data = sc.nextInt();
                    System.out.print("Insert Index: ");
                    int idx = sc.nextInt();
                    dll.add(data, idx);
                    break;
                case 4:
                    dll.removeFirst();
                    break;
                case 5:
                    dll.removeLast();
                    break;
                case 6:
                    System.out.print("Input index: ");
                    dll.removeIndex(sc.nextInt());
                    break;
                case 7:
                    dll.print();
                    break;
                case 8:
                    System.out.print("Search data: ");
                    dll.search(sc.nextInt());
                    break;
                case 9:
                    dll.sort();
                    break;
            }
        }while(menu > 0 && menu < 10);
    }
}
