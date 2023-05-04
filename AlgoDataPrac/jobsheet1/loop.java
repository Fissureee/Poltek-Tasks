import java.util.Scanner;
/**
 * loop
 */
public class loop {

    public static void main(String[] args) {
        printDays();
    }

    public static int nimInput(){
        Scanner input = new Scanner(System.in);
        String nim;
        int n = 0;
        System.out.print("Input NIM: ");
        nim = input.next();
        input.close();
        String index = Character.toString(nim.charAt(nim.length()-2));
        index += Character.toString(nim.charAt(nim.length()-1));
        n = Integer.parseInt(index); //this can also be shortened if I used nim % 100 :)
        return n;
    }

    public static void printDays(){
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int twoDigit = nimInput();
        int iteration = (twoDigit < 10) ? twoDigit + 10 : twoDigit;
        int count = 0;
        for (int i = 0; i < iteration; i++){
            if(count > 6) count = 0;
            System.out.print(days[count] + " ");
            count ++;
        }
    }
}