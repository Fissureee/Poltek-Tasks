package tugas;

public class Main {
    public static void main(String[] args) {
        // Instantiate objects for Mac, Windows, and Pc
        Mac macComputer = new Mac("MacBook Pro", 2500, 16, "Intel Core i7", "Lithium-ion", "macOS");
        Windows windowsComputer = new Windows("Dell XPS", 3200, 32, "Intel Core i9", "Li-Poly", "Windows 10");
        Pc pcComputer = new Pc("Custom Build", 3000, 64, "AMD Ryzen 9", 27);

        // Display data for Mac
        System.out.println("=== Mac Computer ===");
        macComputer.tampilMac();
        System.out.println();

        // Display data for Windows
        System.out.println("=== Windows Computer ===");
        windowsComputer.tampilWindows();
        System.out.println();

        // Display data for Pc
        System.out.println("=== PC Computer ===");
        pcComputer.tampilPc();
    }
}
