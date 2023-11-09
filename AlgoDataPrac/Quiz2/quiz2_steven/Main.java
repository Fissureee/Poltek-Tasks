/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz21f.quiz2_steven;

public class Main {
    public static void main(String[] args){
        SingleLinkedList dll = new SingleLinkedList();
        dll.addFirst(45);
        dll.addFirst(10);
        dll.addFirst(10);
        dll.addFirst(15);
        dll.addFirst(150);
        dll.print();
        dll.deleteFirst();
        dll.print();
        //continue to call addLast, deleteLast,
        dll.addLast(66);
        dll.deleteLast();
        //merge, split,
        split(dll);
        merge(dll, dll);
        dll.print();
    } 
    //2.A.
    public static void merge(SingleLinkedList l1,
            SingleLinkedList l2){
        //This is used to store the value for the tmp which will be used in the traversal
        Node tmp = l2.head;
        //This is used to keep track of the original size of the list, because if we use the direct size from the node itself, when we've added new data the size will also add up so the code will loop infinitely
        int size = l2.size;
        //This loop is for running through every single original node and then adding them to the tail
        for (int i = 0; i < size; i++){
            l1.addLast(tmp.data);
            tmp = tmp.n;
        }
    }
    //2.B. this will split sll to be 2 sll
    public static void split(SingleLinkedList l){
        //ex: 2,3,4,34,2,3,45,4 (original list)
        //1-> 2,3,4,34
        //2-> 2,3,45,4
    }
}
