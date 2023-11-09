package VaccineQueue;

public class QueueNode {
    Person patient;
    QueueNode prev, next;
    public QueueNode(QueueNode prev, String number, String name, QueueNode next){
        this.prev = prev;
        this.next = next;
        patient = new Person(number, name);
    }
}
