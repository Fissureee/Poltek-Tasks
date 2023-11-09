package DataManipulation;

public class DoubleLinkedList {
    Node head;
    int size;

    public DoubleLinkedList() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return  head == null;
    }

    public void addFirst(int item) {
        if (isEmpty()){
            head = new Node(null, item, null);
        } else {
            Node newNode = new Node(null, item, head);
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(int item) {
        if (isEmpty()){
            addFirst(item);
        } else {
            Node current = head;
            while (current.next != null){
                current = current.next;
            }
            Node newNode = new Node(current, item, null);
            current.next = newNode;
            size++;
        }
    }

    public void add(int item, int index) throws Exception{
            if(isEmpty()){
                addFirst(item);
            } else if(index < 0 || index > size){
                throw new Exception("Index out of bound");
            } else {
                Node current = head;
                int i = 0;
                while (i < index) {
                    current = current.next;
                    i++;
                }
                if (current.next == null) {
                    Node newNode = new Node(null, item, current);
                    current.prev = newNode;
                    head = newNode;
                } else {
                    Node newNode = new Node(current.prev, item, current);
                    newNode.prev = current.prev;
                    newNode.next = current;
                    current.prev.next = newNode;
                    current.prev = newNode;
                }
            }
            size++;
    }

    public int size(){
        return size;
    }

    public void clear(){
        head = null;
        size = 0;
    }

    public void print(){
        if (!isEmpty()){
            Node tmp = head;
            while (tmp != null) {
                System.out.print(tmp.data + "\t");
                tmp = tmp.next;
            }
            System.out.println("\nSuccessfully added");
        } else {
            System.out.println("Linked list is empty");
        }
    }

    public void removeFirst(){
        if(isEmpty()){
            System.out.println("The Linked List is Empty");
        } else {
            head = head.next;
            head.prev.next = null;
            head.prev = null;
        }
    }

    public void removeLast(){
        if(isEmpty()){
            System.out.println("The Linked List is Empty");
        } else {
            Node tmp = head;
            while (tmp.next.next != null){
                tmp = tmp.next;
            }
            tmp.next.prev = null;
            tmp.next = null;
        }
    }

    public void removeIndex(int idx){
        Node tmp = head;
        if (isEmpty()){
            System.out.println("The linked list is Empty");
        } else if (idx < 0 || idx > size) {
            System.out.println("Invalid index");
        } else {
            for (int i = 0; i < idx; i++) {
                tmp = tmp.next;
            }
            tmp.next.prev = tmp.prev;
            tmp.prev.next = tmp.next;
            tmp.next = tmp.prev = null;
        }
    }

    public void search(int data){
        Node tmp = head;
        if (isEmpty()){
            System.out.println("The linked list is Empty");
        } else {
            for (int i = 0; i < size-1; i++){
                if(tmp.data == data){
                    System.out.println("Data " + data + " is in index " + i);
                    break;
                }
                tmp = tmp.next;
            }
            if (tmp.data != data){
                System.out.println("Data doesn't exist");
            }
        }
    }
    public void sort() {
        if (isEmpty()) {
            System.out.println("The linked list is empty.");
            return;
        }

        Node current = head;
        boolean swapped;

        do {
            swapped = false;
            current = head;

            while (current.next != null) {
                if (current.data > current.next.data) {
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }
}
