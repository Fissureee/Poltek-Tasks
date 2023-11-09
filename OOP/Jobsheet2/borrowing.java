public class borrowing {
    String member_name, game_name;
    int borrowing_id, bill;

    public borrowing(int id, String member, String game) {
        borrowing_id = id;
        member_name = member;
        game_name = game;
    }

    public void calculate_bill(int duration, int game_price) {
        bill = duration * game_price;
    }

    public void print_data() {
        System.out.println(
                "Borrowing ID: " + borrowing_id +
                        "\nMember Name: " + member_name +
                        "\nGame Name: " + game_name +
                        "\nBill: " + bill);
    }
}