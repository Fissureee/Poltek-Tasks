package Assignment4plus5;

public class BankMain {
    public static void main(String[] args) {
        Customer cust1 = new Customer("Angus", "Walt St. No. 34", "33442211");
        Customer cust2 = new Customer("Landies", "Aldein St. No. 56", "77668855");
        Customer cust3 = new Customer("Lamy", "Beith St. No. 76", "0099889988");

        BankLinkedList CustList = new BankLinkedList();
        CustList.addFirst(cust1);
        CustList.addFirst(cust2);
        CustList.addFirst(cust3);
        CustList.print();
    }
}
