package Receipt;

public class ReceiptStack {
    int size, top;
    Receipt[] data;

    public ReceiptStack(int size){
        this.size = size;
        data = new Receipt[size];
        top = -1;
    }

    public boolean notFull(){
        return top < size-1;
    }

    public void push(Receipt transaction){
        if(notFull()){
            top++;
            data[top] = transaction;
        } else {
            System.out.println("Receipt stack is full");
        }
    }

    public void print(){
        System.out.println("Receipts: ");
        for (int i = top; i >= 0; i--){
            System.out.println(
                    "=============Receipt " + (i+1) + "=============" +
                            "\nTransaction ID\t: " + data[i].id +
                            "\nDate\t: " + data[i].date +
                            "\nItem Quantity\t: " + data[i].quantity +
                            "\nTotal Price\t: " + data[i].totalPrice
            );
        }
        System.out.println();
    }
}
