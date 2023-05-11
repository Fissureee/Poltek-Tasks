package org.example.Student;

import java.util.Scanner;

public class StudentMain {
    public static void menu(){
        System.out.println("Choose menu: ");
        System.out.println("1. Enqueue");
        System.out.println("2. Dequeue");
        System.out.println("3. Print");
        System.out.println("4. Peek");
        System.out.println("5. Clear");
        System.out.println("6. Peek Read");
        System.out.println("7. Peek Position");
        System.out.println("8. Print Students");
        System.out.println("===========================");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Insert maximum queue : ");
        int max = sc.nextInt();
        StudentQueue stdQueue = new StudentQueue(max);

        int choose;
        do {
            menu();
            choose = sc.nextInt();
            sc.nextLine();
            switch (choose) {
                case 1:
                    System.out.print("NIM: ");
                    String nim = sc.nextLine();

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Class Number: ");
                    int classNum = sc.nextInt();

                    System.out.print("GPA: ");
                    Double gpa = sc.nextDouble();

                    Student p = new Student(nim, name, classNum, gpa);
                    stdQueue.enqueue(p);
                    break;
                case 2:
                    Student data = stdQueue.Dequeue();
                    if (!"".equals(data.nim) && !"".equals(data.name) && 0 != data.classNumber && 0  != (data.gpa)){
                        System.out.println("Data removed : " + data.nim + " " + data.name + " " + data.classNumber + " " + data.gpa);
                        break;
                    }
                case 3:
                    stdQueue.print();
                    break;
                case 4:
                    stdQueue.peek();
                    break;
                case 5:
                    stdQueue.clear();
                    break;
                case 6:
                    stdQueue.peekRead();
                    break;
                case 7:
                    System.out.print("Insert nim: ");
                    stdQueue.peekPosition(sc.next());
                    break;
                case 8:
                    System.out.print("Insert index: ");
                    stdQueue.printStudents(sc.nextInt());
                    break;
                default:
                    System.out.println("Invalid Input");
            }
        } while (choose <= 8 && choose >= 1);
    }

}