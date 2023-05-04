package Book;

import Book.Book;
import org.example.Stack;

import java.util.Scanner;

public class BookStackMain {
    public static void main(String[] args) {
        BookStack st = new BookStack(8);
        Scanner sc = new Scanner(System.in);

        char choose;
        do {
            System.out.print("Title : ");
            String title = sc.nextLine();

            System.out.print("Author Name : ");
            String name = sc.nextLine();

            System.out.print("Published Year : ");
            int year = sc.nextInt();

            System.out.print("Pages Amount : ");
            int pages = sc.nextInt();

            System.out.print("Prices : ");
            int price = sc.nextInt();

            Book bk = new Book(title, name, year, pages, price);
            System.out.print("Do you want to add new data to stack (y/n)?");
            choose = sc.next().charAt(0);
            sc.nextLine();
            st.push(bk);
        } while (choose == 'y');

        int menu = 0;
        do {
            System.out.println("========= Menu =========");
            System.out.println("1. Push \n2. Pop \n3. Peek \n4. Print \n5. Exit");
            System.out.print("Input your selection: ");
            int selection = sc.nextInt();
            sc.nextLine();
            switch (selection){
                case 1: {
                    System.out.print("Title : ");
                    String title = sc.nextLine();

                    System.out.print("Author Name : ");
                    String name = sc.nextLine();

                    System.out.print("Published Year : ");
                    int year = sc.nextInt();

                    System.out.print("Pages Amount : ");
                    int pages = sc.nextInt();

                    System.out.print("Prices : ");
                    int price = sc.nextInt();

                    Book bk = new Book(title, name, year, pages, price);
                    sc.nextLine();
                    st.push(bk);
                }
                    break;

                case 2: st.pop();
                    break;

                case 3: st.peek();
                    break;

                case 4: st.print();
                    break;

                default: menu = 5;
            }
        } while (menu != 5);
    }
}
