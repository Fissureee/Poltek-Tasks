package org.example;

public class TicketService {
    Tickets[] list = new Tickets[3];

    int idx;

    public void add(Tickets t){
        if (idx < list.length){
            list[idx] = t;
            idx++;
        } else {
            System.out.println("Ticket is full");
        }
    }

    public void displayAll(){
        for (Tickets show : list){
            show.printData();
            System.out.println("==============================");
        }
    }

    void bubbleSort(){
        for (int i = 0; i< list.length-1; i++){
            for (int j = 1; j<list.length-i; j++){
                if (list[j].price > list[j-1].price){
                    Tickets tmp = list[j];
                    list[j] = list[j-1];
                    list[j-1] = tmp;
                }
            }
        }
    }

    void selectionSort(){
        for (int i=0; i<list.length-1; i++){
            int idx = i;
            for (int j = i + 1; j < list.length; j++){
                if (list[j].price < list[idx].price){
                    idx = j;
                }
            }
            Tickets tmp = list[idx];
            list[idx] = list[i];
            list[i] = tmp;
        }
    }

}
