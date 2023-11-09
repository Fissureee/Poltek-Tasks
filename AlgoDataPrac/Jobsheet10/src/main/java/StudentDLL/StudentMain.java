package StudentDLL;

import java.sql.SQLOutput;
import java.util.Scanner;

public class StudentMain {
    public static void main(String[] args) {
        StudentMethods sm = new StudentMethods();
        Scanner sc = new Scanner(System.in);
        int menu;
        do {
            System.out.println(
                    "1. Add head\n" +
                    "2. Add tail\n" +
                    "3. Add index\n" +
                    "4. Remove head\n" +
                    "5. Remove tail\n" +
                    "6. Remove index\n" +
                    "7. Print\n" +
                    "8. Search\n" +
                    "9. Sort\n" +
                    "10. Exit\n"
            );
            menu = sc.nextInt();
            sc.nextLine();
            switch (menu){
                case 1:
                    sm.addFirst(sm.input());
                    break;
                case 2:
                    sm.addlast(sm.input());
                    break;
                case 3:
                    System.out.print("Index: ");
                    sm.add(sc.nextInt(), sm.input());
                    break;
                case 4:
                    sm.removeFirst();
                    break;
                case 5:
                    sm.removeLast();
                    break;
                case 6:
                    System.out.print("Index: ");
                    sm.remove(sc.nextInt());
                    break;
                case 7:
                    sm.print();
                    break;
                case 8:
                    System.out.print("NIM: ");
                    sm.search(sc.next());
                    break;
                case 9:
                    sm.sort();
            }
        } while( menu > 0 && menu < 10);
    }

}
