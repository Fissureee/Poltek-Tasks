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
        dll.addLast(67);
        dll.addLast(99);
        dll.deleteLast();
        System.out.println("\nThe list after add last and delete last: ");
        dll.print();
        //merge, split,
        System.out.println("\nSplit before merge: ");
        split(dll);
        System.out.println("\nThe list after the merge: ");
        merge(dll, dll);
        dll.print();
        System.out.println("\nSplit after merge: ");
        split(dll);
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

        //Declaring s1 and s2 to store the value from the split process
        SingleLinkedList s1 = new SingleLinkedList();
        SingleLinkedList s2 = new SingleLinkedList();

        //variable size is used to store the original size of the list
        int size = l.size;

        //new node tmp to store the value of head
        Node tmp = l.head;

        //This is used to loop through half of the list and adding the data to the s1 list
        for (int i = 0; i < size/2; i++){
            s1.addLast(tmp.data);
            tmp = tmp.n;
        }

        //This continues from the last loop and adding the data to the s2 list
        for (int i = size/2; i < size; i++){
            s2.addLast(tmp.data);
            tmp = tmp.n;
        }

        //Prints the output
        s1.print();
        s2.print();
    }
}
