package org.example.Passenger;

public class Passengers {
    String name, cityOrigin, cityDestination;
    int price, ticketAmount;

    Passengers(String name, String cityOrigin, String cityDestination, int ticketAmount, int price){
        this.name = name;
        this.cityOrigin = cityOrigin;
        this.cityDestination = cityDestination;
        this.ticketAmount = ticketAmount;
        this.price = price;
    }
}
