package DataManipulation;

public class Node {
    int data;
    Node next, prev;

    public Node(Node prev, int data, Node next){
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
}
