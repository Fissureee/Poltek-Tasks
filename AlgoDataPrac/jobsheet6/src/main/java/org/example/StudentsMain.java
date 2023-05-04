package org.example;

import java.util.Scanner;

public class StudentsMain {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);

        SearchStudent data = new SearchStudent();
        System.out.print("Insert array length: ");
        int amountStudent = s.nextInt();
        data.setArrLeng(amountStudent);

        System.out.println("----------------------------------");
        System.out.println("Input student data accordingly from smallest NIM");
        for (int i = 0; i < amountStudent; i++) {
            System.out.println("----------");
            System.out.print("NIM\t:");
            int nim = s.nextInt();
            System.out.print("Name\t:");
            String name = s1.nextLine();
            System.out.print("Age\t:");
            int age = s.nextInt();
            System.out.print("GPA\t:");
            double gpa = s.nextDouble();

            Students std = new Students(nim, age, name, gpa);
            data.add(std);
        }
        System.out.println("----------------------------");
        System.out.println("Entire Student Data");
        data.display();

        System.out.println("----------------------------");
        System.out.println("Sorted Student Data");
        data.sortData();
        data.display();

        System.out.println("----------------------------");
        System.out.print("Search student by Name: ");
        s.nextLine();
        String nameSearch = s.nextLine();
        System.out.println("Using sequential search");
        data.findStdName(nameSearch);


//        System.out.println("_____________________");
//        System.out.println("_____________________");
//        System.out.print("Search students by NIM: ");
//        int search = s.nextInt();
//        System.out.println("Using Sequential Search");
//        int position = data.findSeqSearch(search);
//
//        data.showPostion(search, position);
//        data.showData(search, position);
//
//        System.out.println("======================");
//        System.out.print("Search student by NIM: ");
//        System.out.println("Using binary Search");
//        int positional = data.findBinarySearch(search, 0, amountStudent - 1);
//
//        data.showPostion(search, position);
//        data.showData(search, position);
    }


}