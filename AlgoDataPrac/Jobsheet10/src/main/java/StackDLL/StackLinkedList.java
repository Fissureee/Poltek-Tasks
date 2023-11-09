package StackDLL;

import DataManipulation.Node;

public class StackLinkedList {
    StackNode head;
    int size;

    public StackLinkedList(){
        head = null;
        size = 0;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void addFirst(String book) {
        if (isEmpty()){
            head = new StackNode(null, book, null);
        } else {
            StackNode newNode = new StackNode(null, book, head);
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void pop(){
        if (isEmpty()){
            System.out.println("Linked list is empty");
        } else {
            System.out.println("Book with the title: " + head.book);
            head = head.next;
            head.prev.next = null;
            head.prev = null;
            System.out.println("Has been removed");
        }
    }

    public void peek(){
        if (isEmpty()){
            System.out.println("Linked list is empty");
        } else {
            System.out.println("Book from the top is: " + head.book);
        }
    }

    public void print(){
        if (isEmpty()){
            System.out.println("Linked list is empty");
        } else {
            StackNode temp = head;
            while (temp != null){
                System.out.println(temp.book);
                temp = temp.next;
            }
        }
    }
}
