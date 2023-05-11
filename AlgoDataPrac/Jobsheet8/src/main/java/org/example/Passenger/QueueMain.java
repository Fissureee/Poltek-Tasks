package org.example.Passenger;

import java.util.Scanner;

public class QueueMain {
    public static void menu(){
        System.out.println("Choose menu: ");
        System.out.println("1. Enqueue");
        System.out.println("2. Dequeue");
        System.out.println("3. Print");
        System.out.println("4. Peek");
        System.out.println("5. Peek Rear");
        System.out.println("6. Clear");
        System.out.println("===========================");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Insert maximum queue : ");
        int max = sc.nextInt();
        QueuePassangers queuePassangers = new QueuePassangers(max);

        int choose;
        do {
            menu();
            choose = sc.nextInt();
            sc.nextLine();
            switch (choose) {
                case 1:
                    System.out.print("Name: ");
                    String nm = sc.nextLine();
                    System.out.print("City Origin: ");
                    String cOrg = sc.nextLine();
                    System.out.print("City Destination: ");
                    String cDes = sc.nextLine();
                    System.out.print("Ticket Amount: ");
                    int ticket = sc.nextInt();
                    System.out.print("Price: ");
                    int price = sc.nextInt();
                    Passengers p = new Passengers(nm, cOrg, cDes, ticket, price);
                    sc.nextLine();
                    queuePassangers.enqueue(p);
                    break;
                case 2:
                    Passengers data = queuePassangers.Dequeue();
                    if (!"".equals(data.name) && !"".equals(data.cityOrigin) && !"".equals(data.cityDestination) && !"".equals(data.ticketAmount) && !"".equals(data.price)){
                        System.out.println("Data removed : " + data.name + " " + data.cityOrigin + " " + data.cityDestination + " " + data.ticketAmount + " " + data.price);
                        break;
                    }
                case 3:
                    queuePassangers.print();
                    break;
                case 4:
                    queuePassangers.peek();
                    break;
                case 5:
                    queuePassangers.peekRear();
                    break;
                case 6:
                    queuePassangers.clear();
                    break;
            }
        } while (choose <= 5 && choose >= 1);
    }

}
