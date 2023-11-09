package quiz21f.quiz2_steven;

public class SingleLinkedList {
    Node head, tail;
    int size;
    
    SingleLinkedList(){
        head = tail = null;
        size=0;
    }
    boolean isEmpty(){
        return size==0;
    }
    void addFirst(int data){
        Node nu = new Node(data);
        if(isEmpty()){
            head = tail = nu;
        }else{
            nu.n = head;
            head = nu;
        }
        size++;
    } 
    void deleteFirst(){
        Node tmp = head.n;
        head = head.n;
        tmp = null;
        size--;
    }
    void print(){
        Node tmp = head;
        while(tmp!=null){
            System.out.print(""+tmp.data+"-");
            tmp = tmp.n;
        }
        System.out.println("");
    } 
    //1.A. complete the missing code addLast
    /**
     * this method will add new node at the last
     */
    void addLast(int data){
        Node nu = new Node(data);
        if(isEmpty()){
            head = tail = nu;
        }else{
            //This code is to save the value of head to a temporary variable (tmp)
           Node tmp = head;
           //This loop is a traversal which is used to find the last node
           while(tmp.n != null){
               tmp = tmp.n;
           }
           //This code is used to add a new node with the new data to the end of the last node
           tmp.n = nu;
        }
        size++;
    }
    //1.B. complete the deleteLast
    /**
     * this method will remove tail
     */
    void deleteLast(){
        //This is to make sure that the 'delete' function won't run if the list is empty
       if (isEmpty()){
           System.out.println("There is nothing to delete here");
       } else {
           //This code is to save the value of head to a temporary variable (tmp)
           Node tmp = head;
           //This loop is a traversal which is used to find the second to last node
           while(tmp.n.n != null){
               tmp = tmp.n;
           }
           //This is used to cut off the last node by making the second to last node's 'n' value null
           tmp.n = null;
           //This is used to keep track of the size of the list
           size--;
       }
        
    }
}
