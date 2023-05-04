import java.util.Scanner;
public class tableCalc {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input row leng: ");
        int i = sc.nextInt();
        System.out.print("Input column leng: ");
        int j = sc.nextInt();
        String continueMenu = "";

        int[][] arr = new int[i][j];
        String[] location = new String[i*j];
        int qty = 0, small = 0, index = 0;
        boolean isThere50 = false;

        for(int row = 0; row < arr.length; row++){
            for(int col = 0; col < arr[0].length; col++){
                System.out.printf("Input value in [%d][%d]: ", row, col);
                arr[row][col] = sc.nextInt();
                small = arr[row][col];
            }
        }

        for(int row = 0; row < arr.length; row++){
            for(int col = 0; col < arr[0].length; col++){
                small = (arr[row][col] < small) ? arr[row][col] : small;
            }
        }
        

        for(int row = 0; row < arr.length; row++){
            for(int col = 0; col < arr[0].length; col++){
                if (arr[row][col] == small) {
                    location[index] = "Smallest is in row: " + row + " column: " + col + "\n";
                    qty++;
                } else {location[index] = "";}
                index ++;
            }
        }

        for(int row = 0; row < arr.length; row++){
            for(int col = 0; col < arr[0].length; col++){
                isThere50 = (arr[row][col] == 50);
                if (isThere50){
                    row = arr.length;
                    col = arr[0].length;
                }
            }
        }

        do {
            System.out.print("Menu: \na. MIN Value(a) \nb. MIN Value & Amount(b) \nc. Array conditions(c) \nInput your choice: ");
            String menu = sc.next();
            switch (menu) {
                case "a":
                    System.out.printf("The smallest number is %d\n", small, qty);
                    break;

                case "b":
                    System.out.printf("The smallest number is %d \nWith the quantity of %d \n", small, qty);
                    for (String loc : location) {
                        System.out.print((loc == "") ? "" : loc);
                    }
                    break;

                case "c":
                    System.out.println((isThere50) ? "FOUND" : "NOT FOUND");
                    break;

                default:
                    System.out.println("Your input is invalid");
                    break;
            }
            System.out.print("Do you want to chose another menu? (y/n) ");
            continueMenu = sc.next();
            
        } while (continueMenu.equals("y") || continueMenu.equals("Y"));
        sc.close();
    }
}