package org.example;

import java.util.Scanner;

public class Squared {
    public int num, squared;

    public int squaredBF(int a, int n){
        int result = 1;
        for (int i = 0; i < n; i++) {
            result = result * a;
        }
        return result;
    }

    public int squaredDC(int a, int n){
        if(n==0){
            return 1;
        }
        else {
            if(n%2==1) return ( squaredDC(a,n/2) * squaredDC(a, n/2) * a);
            else return ( squaredDC(a,n/2) * squaredDC(a, n/2) );
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=======================================================");
        System.out.print("Input the number of elements you want to count : ");
        int element = sc.nextInt();
        Squared [] png = new Squared[element];

        for (int i = 0; i < element; i++) {
            png[i] = new Squared();
            System.out.print("Input the value to be squared to-"+(i+1)+" : ");
            png[i].num = sc.nextInt();
            System.out.print("Input the squared value to-"+(i+1)+" : ");
            png[i].squared = sc.nextInt();
        }

        System.out.println("====================================================");
        System.out.println("Results with Brute Force Squared");
        for (int i = 0; i < element; i++){
            System.out.println("Value "+png[i].num+" squared "+png[i].squared+" is : "+png[i].squaredDC(png[i].num,png[i].squared));
        }
        System.out.println("====================================================");
        System.out.println("Results with Divide and Conquer squared");
        for (int i = 0; i < element; i++){
            System.out.println("Value "+png[i].num+" squared "+png[i].squared+" : "+png[i].squaredDC(png[i].num,png[i].squared));
        }
        System.out.println("====================================================");
    }
}
