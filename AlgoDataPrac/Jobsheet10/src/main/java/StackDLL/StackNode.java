package StackDLL;

public class StackNode {
    String book;
    StackNode next, prev;
    public StackNode(StackNode prev,String book, StackNode next){
        this.book = book;
        this.prev = prev;
        this.next = next;
    }
}
