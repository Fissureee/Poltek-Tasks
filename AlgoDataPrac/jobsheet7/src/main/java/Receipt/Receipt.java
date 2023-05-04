package Receipt;

public class Receipt {
    int date, quantity, totalPrice;
    String id;

    Receipt(String id, int date, int quantity, int totalPrice){
        this.id = id;
        this.date = date;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public void show(int idx){

    }
}
