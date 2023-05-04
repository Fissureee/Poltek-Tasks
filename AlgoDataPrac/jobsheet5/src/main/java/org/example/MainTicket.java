package org.example;

import java.util.Scanner;

public class MainTicket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TicketService data = new TicketService();
        for (int i = 0; i < 3; i++){
            System.out.print("Airline = ");
            String airlines = sc.next();
            System.out.print("Destination = ");
            String destination = sc.next();
            System.out.print("Origin = ");
            String origin = sc.next();
            System.out.print("Price = ");
            int price = sc.nextInt();

            Tickets inputTicket = new Tickets(airlines, destination, origin, price);
            data.add(inputTicket);
        }

        System.out.println("Unsorted ticket list: ");
        data.displayAll();
        sc.nextLine();
        System.out.print("Input the sort type you want(a = ascending / d = descending): ");
        boolean sortType = (sc.next().equals("a"));
        if (sortType){
            System.out.println("Ascending ticket list: ");
            data.selectionSort();
        } else {
            System.out.println("Descending ticket list: ");
            data.bubbleSort();
        }
        data.displayAll();
    }
}