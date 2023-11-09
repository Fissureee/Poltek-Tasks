

public class DLL {
    Node2P head;

    public DLL() {
        head = null;
    }
    
    //soal 1
    int[] toArray(){
       int[] container = new int[size()];
        //To used as a pointer to be used in the traversal process
       Node2P temp = head;
       //To check whether the list is empty or not
       if (!isEmpty()){
           //To be used as the index for the array
           int index = 0;
           //To traverse through the list
           do{
               //Add the data from the current traversal process to the current array index
                container[index] = temp.data;
                temp = temp.next;
                index++;
           }while(temp != null);
       }
       return container;
    }

    //soal 2
    DLL sublist(int start, int end){
        DLL sub = new DLL();
        //To used as a pointer to be used in the traversal process
        Node2P temp = head;
        //This will be used to check if the current traversal is the same as the start index
        int count = 0;
        //This is to traverse until the last index
        do {
            //This checks if the current traversal is already at the start index, if yes then it will start to add all the data to the new sublist
            if (count >= start){
                sub.addLast(temp.data);
            }
            count ++;
            temp = temp.next;
        } while (count <= end);
        return sub;
    }

    //soal 3
    void addAll(DLL list){
        //To used as a pointer to be used in the traversal process
        Node2P temp = head;
        //To traverse to the last node, in other words to search for the tail
        do {
            temp = temp.next;
        } while (temp.next != null);
        //To add the head of the new list to the end of the tail
        temp.next = list.head;
        list.head.prev = temp;
    }

    //soal 4
    boolean containsAll(DLL list){
        //To used as a pointer to be used in the traversal process
        Node2P temp = head;
        Node2P search = list.head;
        //To store the value of how many data is actually contained, this starts from 1 so that I don't have to decrease the value of the size when comparing
        int count = 1;
        //To traverse through the new list
        do {
            //To traverse through the current list
            do {
                //If there is a match then we add it to the count
                if (temp.data == search.data){
                    count++;
                    break;
                }
                temp = temp.next;
            } while (temp.next != null);
            search = search.next;
        } while (search.next != null);
        //If the count is the same as the size of the new list then that means that all of the data in the new list is present in the current list
        return count == list.size();
    }

    //soal 5
    void removeAll(DLL list){
        //To used as a pointer to be used in the traversal process
        Node2P delete = list.head;
        //This is used to traverse through the data's in the given list
       do{
           //This is to call the method deleteByData() to delete the given data from the list
           deleteByData(delete.data);
           delete = delete.next;
       } while (delete != null);
    }

    int get(int idx){
        if(idx<0||idx>=size()){
            System.out.println("Idx invalid!");
            return -1;
        }else{
            Node2P tmp = head;
            for(int i=0;i<idx;i++){
                tmp=tmp.next;
            }
            return tmp.data;
        }
    }

    void deleteByData(int data){
        Node2P tmp = head;
        while(tmp!=null){
            if(tmp.data == data){
                if(tmp.prev == null){
                    deleteFirst();
                }else if(tmp.next == null){
                    deleteLast();
                }else{
                    tmp.prev.next = tmp.next;
                    tmp.next.prev = tmp.prev;
                }
            }
            tmp = tmp.next;
        }
    }

    boolean isEmpty(){
        return head==null? true:false;
    }
    int size(){
        int n = 0;
        Node2P tmp = head;
        while (tmp!=null){
            n++;
            tmp = tmp.next;
        }
        return n;
    }
    
       void addLast(int in){
        Node2P newNode = new Node2P(in);
        if(isEmpty()){
            head = newNode;
        }else{
            Node2P tmp = head;
            while(tmp.next!=null){
                tmp = tmp.next;
            }
            tmp.next = newNode;
            newNode.prev = tmp;
        }     
    }
    
    void deleteFirst(){
        if(isEmpty()){
            System.out.println("Data kosong! operasi deleteFirst gagal!");
        }else if(size()==1){
            head=null;
        }else{
            Node2P del = head;
            head.next.prev = null;
            head = head.next;
            del = null;
        }
    }
    void deleteLast(){
        if(isEmpty()){
            System.out.println("Data kosong! Operasi deleteLast gagal!");
        }else if(size()==1){
            head=null;
        }else{
            Node2P tmp = head;
            while(tmp.next!=null){
                tmp=tmp.next;
            }
            tmp.prev.next = null;
            tmp.prev = null;
            tmp = null;
        }
    }
    
    void print(){
        if(isEmpty()){
            System.out.println("Data kosong! Operasi print gagal");
        }else{
            Node2P tmp = head;
            while(tmp!=null){
                System.out.print(""+tmp.data);
                if(tmp.next!=null)
                    System.out.print("-");
                tmp=tmp.next;
            }
            System.out.println("");
        }
    }
}
