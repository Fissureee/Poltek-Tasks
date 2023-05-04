import java.util.Scanner;

/**
 * royalGarden
 */
public class royalGarden {
    public static Scanner sc = new Scanner(System.in);
    public static int[][] stock = {
            {10, 5, 15, 7},
            {6, 11, 9, 12},
            {2, 10, 10, 5},
            {5, 7, 12, 9},
    };

    public static String[] flowers = {"Aglaonema", "Taro", "Alocasia", "Rose"};
    public static void main(String[] args) {
        selectMenu();
    }

    private static void selectMenu(){
        boolean cont = true;
        do{
            System.out.print("\nMenu \n1. Show Table \n2. Minus Stock\n3. Total Income\n4. Exit \n");
            System.out.print("Input menu: ");
            int menu = sc.nextInt();
            switch (menu){
                case 1 : showTable(); break;
                case 2 : decreaseStoock(); break;
                case 3 : showTotalIncome(); break;
                default: cont = false;
            }
        }while(cont);
    }

    private static void showTable(){
        System.out.printf("\n%-16s", "");
        for (String flower : flowers){
            System.out.printf("%-" + (flower.length()+3) + "s", flower);
        }

        System.out.println();

        System.out.print("RoyalGarden       ");
        for(int row = 0; row < 4; row++){
            int totalFlower = 0;
            int count = 0;
            for (int col = 0; col < 4; col++){
                totalFlower += stock[col][row];
            }
            System.out.printf("%-" + (flowers[count].length()+1) + "s", totalFlower);
            count ++;
        }
    }

    private static void decreaseStoock(){
        boolean cont = false;
        do{
            System.out.print("Input the store: ");
            int row = sc.nextInt();
            System.out.print("Input flower col: ");
            int col = sc.nextInt();
            System.out.print("Input dead or withered flower: ");
            stock[row][col] -= sc.nextInt();
            System.out.print("Continue? ");
            cont = (sc.next().equals("y"));
        } while (cont);

    }

    private static void showTotalIncome(){
        int[] price = {75000, 50000, 60000, 10000};
        int totalPrice = 0;
        for (int col = 0; col < 4; col++){
            totalPrice += stock[0][col]*price[col];
        }
        System.out.println("Total income is " + totalPrice);
    }
}