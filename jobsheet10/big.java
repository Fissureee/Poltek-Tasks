/**
 * big
 */
public class big {

    public static void main(String[] args) {
        int a = 20, b = 160, c = 32;
        System.out.println(Max3(a, b, c));
    }

    static int Max3(int bil1, int bil2, int bil3) {
        int bigChungus = 0;
        bigChungus = (bil1 > bigChungus) ? bil1 : bigChungus;
        bigChungus = (bil2 > bigChungus) ? bil2 : bigChungus;
        bigChungus = (bil3 > bigChungus) ? bil3 : bigChungus;
        return bigChungus;
    }
}