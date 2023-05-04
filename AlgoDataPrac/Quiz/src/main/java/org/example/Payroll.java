package org.example;

public class Payroll {
    String payrollID, employeeID, employeeName;
    static String level;
    static int baseSalary;
    static int[] allowance = new int[4];
    static boolean isPermanent;

    Payroll(String payrollID, String employeeID, String employeeName, String level, boolean isPermanent){
        this.payrollID = payrollID;
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.level = level;
        this.baseSalary = calcBaseSalary();
        this.allowance = calcAllowance();
        this.isPermanent = isPermanent;
    }
    Payroll(){}

    public static int[] calcAllowance(){
        int[] fillAllowance = new int[4];
        if(isPermanent){
            fillAllowance[0] = 500000;
            fillAllowance[1] = 600000;
            fillAllowance[2] = 700000;
            fillAllowance[3] = 800000;
        } else {
            fillAllowance[0] = 100000;
            fillAllowance[1] = 200000;
            fillAllowance[2] = 300000;
            fillAllowance[3] = 400000;
        }
        return fillAllowance;
    }
    public static int calcTotalAllowance(){
        int totalAllowance = 0; //This to instantiate the variable totalAllowance which we will use to store the final result
        for(int value : allowance){//Here for each is used to take each of the value in allowance and then add it up into totalAllowance
            totalAllowance += value;
        }
        return totalAllowance;//This is to return the value of totalAllowance
    }

    public static int calcBaseSalary(){
        int bsSalary;
        switch (level) {
            case "3A":
                bsSalary = 2_000_000;
                break;
            case "3B":
                bsSalary = 2_500_000;
                break;
            case "3C":
                bsSalary = 3_000_000;
                break;
            default:
                bsSalary = 3_750_000;
                break;
        }
        return bsSalary;
    }

    public static int calcHealthBenefit(){
        int healthBenefit = 0;
        if(isPermanent){
            switch (level) {
                case "3A":
                    healthBenefit += (baseSalary / 100) * 5;
                    break;
                case "3B":
                    healthBenefit += (baseSalary / 100) * 7;
                    break;
                case "3C":
                    healthBenefit += (baseSalary / 100) * 9;
                    break;
                default:
                    healthBenefit += (baseSalary / 100) * 11;
                    break;
            }
        }
        return healthBenefit;
    }

    public static int calcTotalSalary(){
        return baseSalary + calcTotalAllowance() + ((isPermanent) ? calcHealthBenefit() : 0);
        //the last part is to determine if the person is permanent employee or not, if yes then it will total with the healthBenefit if not it will just add 0
    }
}
