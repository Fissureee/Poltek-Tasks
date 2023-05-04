package org.example;

public class Tickets {
    String airlines, destination, origin;
    int price;

    Tickets(String a, String dest, String origin, int price){
        airlines = a;
        destination = dest;
        this.origin = origin;
        this.price = price;
    }
    Tickets(){}

    void printData(){
        System.out.println(
                "Airlines :" + airlines +
                "\nDestination :" + destination +
                "\nOrigin :" + this.origin +
                "\nPrice :" + this.price
        );
    }
}
