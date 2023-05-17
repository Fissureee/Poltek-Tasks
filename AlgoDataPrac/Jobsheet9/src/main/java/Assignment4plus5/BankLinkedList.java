package Assignment4plus5;

public class BankLinkedList {
    BankNode head;
    BankNode tail;

    public boolean isEmpty() {
        return head == null;
    }

    public void print() {
        if(!isEmpty()){
            BankNode tmp = head;
            System.out.print("Linked list content: \t");
            while (tmp != null) {
                tmp.data.printData();
                tmp = tmp.next;
            }
            System.out.println();
        }else{
            System.out.println("Linked list is empty");
        }
    }

    public void addFirst(Customer input){
        BankNode ndInput = new BankNode(input, null);
        if(isEmpty()){
            head = ndInput;
            tail = ndInput;
        }else{
            ndInput.next = head;
            head = ndInput;
        }
    }
}
