package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Payroll[] arrayOfPayrolls = new Payroll[5];
        for(int i = 0; i < 5; i++){
            System.out.println("Employee " + i);

            System.out.print("Input Payroll ID: ");
            String payrollID = sc.next();

            System.out.print("Input Employee ID: ");
            String employeeID = sc.next();

            System.out.print("Input Employee Name: ");
            String employeeName = sc.next();

            String level;
            do {
                System.out.print("Input Class: ");
                level = sc.next();
            } while(!doesLevelExist(level)); //This is to make sure that the level user inputed exists

            System.out.print("Is This Employee Permanent?(y/n) ");
            boolean isPermanent= (sc.next()).equals("y");

            System.out.println();

            arrayOfPayrolls[i] = new Payroll(payrollID, employeeID, employeeName, level, isPermanent);
        }

        System.out.println("The average total salary for all 4A employee: " + calcAvgTotalSalary4A(arrayOfPayrolls));
        int maxId = findBiggestTotalSalary(arrayOfPayrolls);
        System.out.printf("The biggest total salary is employee id %s with the name %s \n", arrayOfPayrolls[maxId].employeeID, arrayOfPayrolls[maxId].employeeName );
        System.out.println("Total Health Benefit that needs to be paid: " + calcTotalHealthBenefit(arrayOfPayrolls));
    }

    public static boolean doesLevelExist(String level){
        //This function is used to check if the level exists
        return level.equals("3A") || level.equals("3B") || level.equals("3C") || level.equals("4A");
    }

    public static int calcAvgTotalSalary4A(Payroll[] arrayOfPayrolls){
        int avgPayroll = 0;
        for(int i = 0; i < 5; i++){
            if(arrayOfPayrolls[i].level.equals("4A")){
                avgPayroll += arrayOfPayrolls[i].calcTotalSalary();
            }
        }
        return avgPayroll /= 5;
    }

    public static int findBiggestTotalSalary(Payroll[] arrayOfPayrolls){
        int maxPayroll = arrayOfPayrolls[0].calcTotalSalary();
        int maxId = 0;
        for(int i = 1; i < 5; i++){
            maxPayroll = (arrayOfPayrolls[i].calcTotalSalary() > maxPayroll) ? arrayOfPayrolls[i].calcTotalSalary() : maxPayroll;
            maxId = i;
        }
        return maxId;
    }

    public static int calcTotalHealthBenefit(Payroll[] arrayOfPayrolls){
        int totalHealthBenefit = 0;
        for(int i = 0; i < 5; i++){
            totalHealthBenefit += arrayOfPayrolls[i].calcHealthBenefit();
        }
        return totalHealthBenefit;
    }
}