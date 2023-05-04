import java.util.Scanner;

public class SmileLaundry {
    static double countPrice(int weight) {
        double price;
        price = weight * 4500;
        if (weight > 10) {
            price -= (price / 100) * 5;
        }
        return price;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] weightList = new int[4];
        for (int i = 0; i < 4; i++) {
            System.out.print("Input the weight: ");
            weightList[i] = sc.nextInt();
        }

        int totalIncome = 0;
        for(int p : weightList){
            totalIncome += countPrice(p);
        }

        System.out.println("The total income for today is " + totalIncome);
    }
}
