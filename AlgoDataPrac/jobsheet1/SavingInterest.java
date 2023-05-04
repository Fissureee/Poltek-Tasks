public class SavingInterest {
    public static void main(String[] args) {
        double bankBalance = 1_000_000;
        int count = 0;
        do {
            bankBalance += (bankBalance/100) * 2;
            count++;
        } while (bankBalance < 1_500_000);

        System.out.printf("You will need %d month to reach 1.5 mil", count);
    }

}