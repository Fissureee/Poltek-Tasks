package Banking;

public class Account {
    String accNumber, name, phone, email;
    int initBalance;

    public Account(String accNumber, String name, String phone, String email, int initBalance){
        this.accNumber = accNumber;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.initBalance = initBalance;
    }

    public void print(){
        System.out.println(
                "Account Number\t: " + accNumber +
                "\nName\t:" + name +
                "\nPhone Number\t: " + phone +
                "\nEmail\t: " + email +
                "\nInitial Balance\t: " + initBalance
        );
    }
}
