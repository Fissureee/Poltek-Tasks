package org.example.Student;

public class StudentQueue {
    int max, size, front, rear;
    Student[] stdQueue;
    public StudentQueue(int n) {
        max = n;
        Create();
    }

    public void Create(){
        stdQueue = new Student[max];
        size = 0;
        front = rear = -1;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull(){
        if (size == max) {
            return true;
        } else {
            return false;
        }
    }

    public void peek(){
        if (!isEmpty()) {
            System.out.println("The first element : " + stdQueue[front]);
        } else {
            System.out.println("Queue is still empty");
        }
    }

    public void print(){
        if (isEmpty()){
            System.out.println("Queue is still empty");
        }else{
            int i = front;
            while(i != rear){
                System.out.println(
                        "The first element : " + stdQueue[front].nim +
                                " " + stdQueue[front].name +
                                " " + stdQueue[front].classNumber +
                                " " + stdQueue[front].gpa
                );
                i = (i+1) % max;
            }
            System.out.println(stdQueue[i] + " ");
            System.out.println("Element amount : " + size);
        }
    }

    public void clear(){
        if (!isEmpty()){
            front = rear = -1;
            size = 0;
            System.out.println("Queue has been cleared successfully");
        } else {
            System.out.println("Queue is still empty");
        }
    }

    public void enqueue(Student data){
        if (isFull()){
            System.out.println("Queue is already full");
        } else {
            if (isEmpty()){
                front = rear = 0;
            }else{
                rear++;
            }
        }
        stdQueue[rear] = data;
        size++;
    }

    public Student Dequeue(){
        Student data = new Student("", "", 0, 0.0);
        if (isEmpty()){
            System.out.println("Queue is still empty");
        }else{
            data = stdQueue[front];
            size--;
            if (isEmpty()){
                front = rear = -1;
            } else {
                if (front == max -1){
                    front = 0;
                } else {
                    front++;
                }
            }
        }
        return data;
    }

    public void peekRead(){
        if (!isEmpty()) {
            System.out.println("The last element : " + stdQueue[rear]);
        } else {
            System.out.println("Queue is still empty");
        }
    }

    public void peekPosition(String search){
        for (int i = 0; i < stdQueue.length; i++){
            if (stdQueue[i].nim.equals(search)){
                System.out.println(
                        "The first element : " + stdQueue[i].nim +
                                " " + stdQueue[i].name +
                                " " + stdQueue[i].classNumber +
                                " " + stdQueue[i].gpa
                );
            }
        }
    }

    public void printStudents(int id){
        if (id <= rear && id >= front){
            System.out.println(
                    "Student data : " + stdQueue[id].nim +
                            " " + stdQueue[id].name +
                            " " + stdQueue[id].classNumber +
                            " " + stdQueue[id].gpa
            );
        } else {
            System.out.println("Data does not exist");
        }
    }
}
