package assignment2;

public class A2main {
    public static void main(String[] args) {
        A2LinkedList A2LL = new A2LinkedList();
        A2LL.addFirst('a');
        A2LL.print();
        A2LL.addLast('b');
        A2LL.print();
        A2LL.insertAfter('b', 'c');
        A2LL.print();
        A2LL.insertAt(3, 'd');
        A2LL.print();
        A2LL.addLast('e');
        A2LL.print();
    }
}
