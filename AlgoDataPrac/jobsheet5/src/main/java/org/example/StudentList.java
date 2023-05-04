package org.example;

public class StudentList {
    Student[] list = new Student[5];
    int idx;

    void add(Student std){
        if(idx<list.length){
            list[idx] = std;
            idx++;
        } else {
            System.out.println("The student list is already full-filled");
        }
    }

    void print(){
        for (Student s : list){
            s.print();
            System.out.println("=========================");
        }
    }

    void bubbleSort(){
        for (int i = 0; i< list.length-1; i++){
            for (int j = 1; j<list.length-i; j++){
                if (list[j].gpa > list[j-1].gpa){
                    Student tmp = list[j];
                    list[j] = list[j-1];
                    list[j-1] = tmp;
                }
            }
        }
    }

    void selectionSort(){
        for (int i=0; i<list.length-1; i++){
            int idx = i;
            for (int j = i + 1; j < list.length; j++){
                if (list[j].gpa < list[idx].gpa){
                    idx = j;
                }
            }
            Student tmp = list[idx];
            list[idx] = list[i];
            list[i] = tmp;
        }
    }

    void insertionSort(boolean ascending) {
        for (int i = 0; i < list.length; i++) {
            Student temp = list[i];
            int j = i;
            if(ascending) {
                while (j > 0 && list[j - 1].gpa > temp.gpa){
                    list[j] = list[j - 1];
                    j--;
                }
            }else {
                while (j > 0 && list[j - 1].gpa < temp.gpa){
                    list[j] = list[j - 1];
                    j--;
                }
            }
            list[j] = temp;
        }
    }

}
