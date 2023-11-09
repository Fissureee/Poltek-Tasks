package VaccineQueue;

public class QueueLinkedList {
    QueueNode head;
    int size;

    public QueueLinkedList(){
        head = null;
        size = 0;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void add(String number, String name){
        if(isEmpty()){
            head = new QueueNode(null, number, name, null);
        } else {
            QueueNode current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = new QueueNode(current, number, name, null);
        }
        size++;
    }

    public void remove(){
        if (isEmpty()){
            System.out.println("There is no one to vaccinate");
        } else {
            System.out.println(head.patient.name + "has been vaccinated !");
            head = head.next;
            head.prev.next = null;
            head.prev = null;
            size--;
            System.out.println("There is " + size + " patient left");
        }
    }

    public void print(){
        if (isEmpty()){
            System.out.println("There is no one to vaccinate");
        } else {
            QueueNode temp = head;
            System.out.println("Current vaccine queue: ");
            while(temp != null){
                System.out.printf("|%-9s|%-9s|\n", temp.patient.number, temp.patient.name);
                temp = temp.next;
            }
            System.out.println("Queue left: " + size);
        }
    }
}
