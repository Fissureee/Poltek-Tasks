package org.example;

public class SearchStudent {
        Students[] listStd;
        int idx;

        public void setArrLeng(int arrLeng){
            listStd = new Students[arrLeng];
        }

        public void add(Students std){
            if(idx < listStd.length){
                listStd[idx] = std;
                idx++;
            } else {
                System.out.println("Data is already full");
            }
        }

        public void display() {
            for (Students students : listStd) {
                students.display();
                System.out.println("-----------------------------");
            }
        }

        public int findSeqSearch(int search) {
            int position = -1;
            for (int i = 0; i < listStd.length; i++){
                if (listStd[i].nim == search) {
                    position = i;
                    break;
                }
            }
            return position;
        }

        public void findStdName(String nameSearch) {
            int position = -1;
            for (int i = 0; i < listStd.length; i++){
                if (listStd[i].name.equals(nameSearch)){
                    System.out.printf("Student name: %s \nis found in index %d", nameSearch, i);
                }
            }
        }

        public void showPostion(int x, int pos){
            if (pos != -1){
                System.out.println("Data : "+ x +" is found in index-"+pos);
            } else {
                System.out.println("Data : "+ x +" is not found");
            }
        }

        public void showData(int x, int pos) {
            if (pos != -1){
                System.out.println("NIM \t : " + x);
                System.out.println("Name \t : " + listStd[pos].name);
                System.out.println("Age \t : " + listStd[pos].age);
                System.out.println("IPK \t : " + listStd[pos].gpa);
            } else {
                System.out.println("Data " + x + " is not found");
            }
        }

        public int findBinarySearch(int cari, int left, int right){
            int mid;
            if (right >= left) {
                mid = (left + right) / 2;
                if (cari == listStd[mid].nim){
                    return (mid);
                } else if (listStd[mid].nim > cari) {
                    return findBinarySearch(cari, left, mid - 1);
                } else {
                    return findBinarySearch(cari, mid + 1, right);
                }
            }
            return -1;
        }

        public void sortData(){
            for (int i = 0; i < listStd.length - 1; i++){
                int idx = 1;
                for (int j = i + 1; j < listStd.length - 1; j++){
                    if (listStd[j].gpa > listStd[idx].gpa){
                        idx = j;
                    }
                }
                Students tmp = listStd[idx];
                listStd[idx] = listStd[i];
                listStd[i] = tmp;
            }
        }
}
