public class Barang {
    String kode, namaBarang;
    int hargaDasar;
    float diskon;

    public int hitungHargaJual() {
        return hargaDasar - (int) (diskon * hargaDasar);
    }

    public void tampilData() {
        System.out.println(
                "Kode: " + kode +
                        "\nNama Barang: " + namaBarang +
                        "\nHarga Dasar: Rp" + hargaDasar +
                        "\nDiskon: " + diskon * 100 + "%" +
                        "\nHarga Jual: " + hitungHargaJual());
    }

    public static void main(String[] args) {
        Barang brg = new Barang();
        brg.kode = "1";
        brg.namaBarang = "Kaos";
        brg.hargaDasar = 35000;
        brg.diskon = 0.3f;
        brg.tampilData();
    }

}
