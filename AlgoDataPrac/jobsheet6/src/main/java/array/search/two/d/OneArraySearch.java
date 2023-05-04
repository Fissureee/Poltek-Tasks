package array.search.two.d;

import org.example.Students;

import java.util.Scanner;

public class OneArraySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] data = {12, 17, 2, 1, 70, 50, 90, 17, 2, 90};

        for (int i = 0; i < data.length - 1; i++) {
            int idx = 1;
            for (int j = i + 1; j < data.length - i; j++){
                if (data[j] > data[idx]){
                    idx = j;
                }
            }
            int tmp = data[idx];
            data[idx] = data[i];
            data[i] = tmp;
        }

        int max = 0;
        for (int i = 0; i < data.length; i++){
            if (data[i] > max){
                max = data[i];
            }
        }
        System.out.printf("Biggest number is %d", max);

        int count = 0;
        int idx = 0;
        for (int i : data){
            if (i == max){
                System.out.printf("\nFound in idx: %d ", idx);
                count++;
            }
            idx++;
        }
        System.out.printf("\nThere are %d data found", count);


    }
}
