package Assignment4plus5;

public class Customer {
    String name, address, accountNumber;

    public Customer(String name, String address, String accountNumber){
        this.name = name;
        this.address = address;
        this.accountNumber = accountNumber;
    }

    public void printData(){
        System.out.println(
                "\nName: " + name +
                "\nAddress: " + address +
                "\nAccount Number:  " + accountNumber
        );
    }
}
