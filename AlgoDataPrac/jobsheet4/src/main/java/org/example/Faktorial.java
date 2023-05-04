package org.example;

import java.util.Scanner;

public class Faktorial {
    public int num;

    public int factorialBF(int n){
        int fakto = 1;
        for (int i = 1; i <= n; i ++){
            fakto = fakto * i;
        }
        return fakto;
    }

    public int factorialDC(int n){
        if (n==1) {
            return 1;
        }
        else {
            int fakto = n * factorialDC(n-1);
            return fakto;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=====================================================");
        System.out.print("Input the number of elements you want to count : ");
        int element = sc.nextInt();

        Faktorial[] fk = new Faktorial[element];
        for(int i =0; i < element; i++) {
            fk[i] = new Faktorial();
            System.out.print("Input the data value to-"+(i+1)+" : ");
            fk[i].num = sc.nextInt();
        }

        System.out.println("=====================================================");
        System.out.println("Factorial Results with Brute Force");
        long startBF = System.nanoTime();
        for (int i = 0; i < element; i++){
            System.out.println("Factorial of value"+fk[i].num+" is : "+fk[i].factorialBF(fk[i].num));
        }
        long endBF = System.nanoTime();
        System.out.println("Execution time: " + (endBF-startBF) +"nanoseconds");
        System.out.println("=====================================================");
        System.out.println("Factorial Results with Divide and Conquer");
        long startDC = System.nanoTime();
        for (int i = 0; i < element; i++){
            System.out.println("Factorial of value"+fk[i].num+" is : "+fk[i].factorialDC(fk[i].num));
        }
        long endDC = System.nanoTime();
        System.out.println("Execution time: " + (endDC-startDC) +"nanoseconds");
        System.out.println("=====================================================");
    }
}
