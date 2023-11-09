package StudentDLL;

import java.util.Scanner;

public class StudentMethods {
    StudentNode head;
    int size;

    public StudentMethods(){
        head = null;
        size = 0;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public Student input(){
        Scanner in = new Scanner(System.in);
        System.out.print("NIM: ");
        String nim = in.next();
        System.out.print("Name: ");
        String name = in.next();
        System.out.print("GPA: ");
        double gpa = in.nextDouble();
        return new Student(nim, name, gpa);
    }

    public void addFirst(Student student){
        if (isEmpty()){
            head = new StudentNode(null, student, null);
        } else {
            head.prev = new StudentNode(null, student, head);
            head = head.prev;
        }
        size++;
    }

    public void addlast(Student student){
        if (isEmpty()){
            addFirst(student);
        } else {
            StudentNode tmp = head;
            while(tmp.next != null){
                tmp = tmp.next;
            }
            tmp.next = new StudentNode(tmp, student, null);
        }
        size++;
    }

    public void add(int index, Student student) {
        if (isEmpty()){
            System.out.println("This linked list is empty");
        } else if (index > size-1 || index < 0){
            System.out.println("The index doesn't exist");
        } else {
            StudentNode tmp = head;
            for (int i = 0; i < index; i++){
                tmp = tmp.next;
            }
            tmp.student = student;
        }
        size++;
    }

    public void removeFirst(){
        if (isEmpty()){
            System.out.println("This linked list is empty");
        } else {
            head = head.next;
            head.prev.next = null;
            head.prev.student = null;
            head.prev = null;
            size--;
        }
    }

    public void removeLast(){
        if (isEmpty()){
            System.out.println("This linked list is empty");
        } else {
            StudentNode tmp = head;
            while(tmp.next.next != null){
                tmp = tmp.next;
            }
            tmp.next.prev = null;
            tmp.next.student = null;
            tmp.next = null;
            size--;
        }
    }

    public void remove(int index){
        if (isEmpty()){
            System.out.println("This linked list is empty");
        } else if (index < 0 || index > size-1){
            System.out.println("Invalid input");
        } else if (index == 0){
            removeFirst();
        } else if (index == size-1){
            removeLast();
        }
        else {
            StudentNode tmp = head;
            for (int i = 1; i < index; i++){
                tmp = tmp.next;
            }
            tmp.next.next.prev = tmp;
            tmp.next = tmp.next.next;
            size--;
        }
    }

    public void print(){
        if (isEmpty()){
            System.out.println("This linked list is empty");
        } else {
            StudentNode tmp = head;
            System.out.println("Students: ");
            do{
                System.out.println(
                        "NIM: " + tmp.student.nim +
                        "\nName: " + tmp.student.name +
                        "\nGPA: " + tmp.student.gpa
                );
                tmp = tmp.next;
            } while(tmp != null);
            System.out.println("All data printed successfully");
        }
    }

    public void search(String nim){
        StudentNode tmp = head;
        int count = 0;
        while (tmp != null){
            if (tmp.student.nim.equals(nim)){
                System.out.println(
                        "Found in node: " + count +
                        "\nNIM: " + tmp.student.nim +
                        "\nName: " + tmp.student.name +
                        "\nGPA: " + tmp.student.gpa
                );
                break;
            }
            tmp = tmp.next;
        }
    }

    public void sort() {
        if (isEmpty()) {
            System.out.println("The linked list is empty.");
            return;
        }

        StudentNode current = head;
        boolean swapped;

        do {
            swapped = false;
            current = head;

            while (current.next != null) {
                if (current.student.gpa < current.next.student.gpa) {
                    double temp = current.student.gpa;
                    current.student.gpa = current.next.student.gpa;
                    current.next.student.gpa = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }
}
