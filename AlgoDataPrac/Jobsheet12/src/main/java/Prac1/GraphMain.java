package Prac1;

import java.sql.SQLOutput;
import java.util.Scanner;

public class GraphMain {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.print("Graph size: ");
        Graph graph = new Graph(sc.nextInt());
        int menu;
        do {
            System.out.print("Menu" +
                    "\n1. Add Edge" +
                    "\n2. Remove Edge" +
                    "\n3. Degree" +
                    "\n4. Print Edge" +
                    "\n5. Exit" +
                    "\nSelect: ");
            menu = sc.nextInt();
            switch (menu){
                case 1:
                    System.out.println("Add Edge ");
                    System.out.print("Source: ");
                    int source = sc.nextInt();
                    System.out.print("Destination: ");
                    int destination = sc.nextInt();
                    graph.addEdge(source, destination);
                    break;

                case 2:
                    System.out.println("Remove Edge ");
                    System.out.print("Source: ");
                    int sourc = sc.nextInt();
                    System.out.print("Destination: ");
                    int dest = sc.nextInt();
                    graph.removeEdge(sourc, dest);
                    break;

                case 3:
                    System.out.println("Input Degree ");
                    System.out.print("Degree: ");
                    int degree = sc.nextInt();
                    graph.degree(degree);
                    break;

                case 4:
                    System.out.println("Print ");
                    graph.printGraph();
                    break;
            }
        }while(menu > 0 && menu < 5);
    }
}
