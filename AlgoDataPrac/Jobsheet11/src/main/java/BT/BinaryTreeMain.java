package BT;

import java.util.Scanner;

public class BinaryTreeMain {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();

        int menu;
        do {
            System.out.println("=========Menu=========");
            System.out.println("1. Add");
            System.out.println("2. Delete");
            System.out.println("3. Find");
            System.out.println("4. traverseInOrder");
            System.out.println("5. traversePreOrder");
            System.out.println("6. traversePostOrder");
            System.out.println("7. Exit");
            System.out.println("=====================");
            menu = sc.nextInt();
            switch (menu) {
                case 1:
                    System.out.print("Data node : ");
                    int data = sc.nextInt();
                    bt.add(data);
                    break;
                case 2:
                    System.out.print("Data node : ");
                    int deleteData = sc.nextInt();
                    bt.delete(deleteData);
                    break;
                case 3:
                    System.out.print("Data node : ");
                    int searchData = sc.nextInt();
                    System.out.println(bt.find(searchData) ? "Found" : "Not Found");
                    break;
                case 4:
                    bt.traverseInOrder(bt.root);
                    System.out.println();
                    break;
                case 5:
                    bt.traversePreOrder(bt.root);
                    System.out.println();
                    break;
                case 6:
                    bt.traversePostOrder(bt.root);
                    System.out.println();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Invalid menu");
                    break;
            }
        } while (menu != 7);
    }
}