package assignment2;

public class A2LinkedList {
    A2node head;
    A2node tail;

    public boolean isEmpty() {
        return head == null;
    }

    public void print() {
        if(!isEmpty()){
            A2node tmp = head;
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

    public void addFirst(char input){
        A2node ndInput = new A2node(input, null);
        if(isEmpty()){
            head = ndInput;
            tail = ndInput;
        }else{
            ndInput.next = head;
            head = ndInput;
        }
    }

    public void addLast(char input){
        A2node ndInput = new A2node(input, null);
        if(isEmpty()){
            head = ndInput;
            tail = ndInput;
        }else{
            tail.next = ndInput;
            tail = ndInput;
        }
    }

    public void insertAfter(char key, char input){
        A2node ndInput = new A2node(input, null);
        A2node temp = head;
        do {
            if (temp.data == key) {
                ndInput.next = temp.next;
                temp.next = ndInput;
                if (ndInput.next == null) tail = ndInput;
                break;
            }
            temp = temp.next;
        } while (temp != null);
    }

    public void insertAt(int index, char input){
        if (index < 0){
            System.out.println("Wrong index");
        }else if(index == 0){
            addFirst(input);
        }else{
            A2node temp = head;
            for(int i = 0; i < index - 1; i++){
                temp = temp.next;
            }
            temp.next = new A2node(input, temp.next);
            if (temp.next.next == null) tail = temp.next;
        }
    }
}
