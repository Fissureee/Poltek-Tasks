package Banking;

public class AccountStack {
    Account[] data;
    int size, top;

    public AccountStack(int size){
        this.size = size;
        data = new Account[size];
        top = -1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == size-1;
    }

    public void push(Account dataIn){
        if (!isFull()){
            data[top+1] = dataIn;
            top++;
        }
    }

    public void print(){
        for (Account acc : data){
            acc.print();
            System.out.println();
        }
    }

    public void sort(){
        for (int i = 0; i < data.length-1; i++){
            for (int j = 1; j < data.length-i; j++){
                if (data[j].initBalance > data[j-1].initBalance){
                    Account tmp = data[j];
                    data[j] = data[j-1];
                    data[j-1] = tmp;
                }
            }
        }
    }

    public void displayAcc0(){
        int count = 0;
        for (int i = 0; i < data.length; i++){
            if (data[i].initBalance == 0){
                data[i].print();
                count ++;
            }
        }
        if (count == 0){
            System.out.println("No account with 0 balance! ");
        }
    }

    public void searchName(String search){
        int count = 0;
        for (int i = 0; i < data.length; i++){
            if (data[i].name.equals(search)){
                data[i].print();
                count ++;
            }
        }
        if (count == 0){
            System.out.printf("No account with the name %s! \n", search);
        }
    }

    public void withdraw(String name, int withdraw){
        int count = 0;
        for (int i = 0; i < data.length; i++){
            if (data[i].name.equals(name)){
                data[i].initBalance = data[i].initBalance - withdraw;
                count ++;
            }
        }
        if (count == 0){
            System.out.printf("No account with the name %s! \n", name);
        }
    }

    public void deposit(String name, int deposit){
        int count = 0;
        for (int i = 0; i < data.length; i++){
            if (data[i].name.equals(name)){
                data[i].initBalance = data[i].initBalance + deposit;
                count ++;
            }
        }
        if (count == 0){
            System.out.printf("No account with the name %s! \n", name);
        }
    }
}
