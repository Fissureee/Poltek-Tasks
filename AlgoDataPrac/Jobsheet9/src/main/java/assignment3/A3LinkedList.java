package assignment3;

public class A3LinkedList {
    A3node head;
    A3node tail;

    public boolean isEmpty() {
        return head == null;
    }

    public void print() {
        if(!isEmpty()){
            A3node tmp = head;
            System.out.print("Linked list content: \t");
            while (tmp != null) {
                System.out.print(tmp.data + "\t");
                tmp = tmp.next;
            }
            System.out.println();
        }else{
            System.out.println("Linked list is empty");
        }
    }

    public void addFirst(String input){
        A3node ndInput = new A3node(input, null);
        if(isEmpty()){
            head = ndInput;
            tail = ndInput;
        }else{
            ndInput.next = head;
            head = ndInput;
        }
    }
}
