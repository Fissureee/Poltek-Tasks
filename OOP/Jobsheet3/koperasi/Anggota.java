package koperasi;

public class Anggota {
    private String KTP, nama;
    private int jumlahPinjaman, limitPinjaman;

    public Anggota (String newKTP, String newNama, int newLimitPinjaman){
        KTP = newKTP;
        nama = newNama;
        limitPinjaman = newLimitPinjaman;
    }

    public String getNama(){
        return nama;
    }

    public int getLimitPinjaman(){
        return limitPinjaman;
    }

    public int getJumlahPinjaman(){
        return jumlahPinjaman;
    }

    public void pinjam(int pinjamDulu){
        if (jumlahPinjaman + pinjamDulu > limitPinjaman){
            System.out.println("Jumlah melebihi limit pinjaman!");
        }
        else {
            jumlahPinjaman += pinjamDulu;
        }
    }

    public void angsur(int angsurDulu){
        if (jumlahPinjaman - angsurDulu < 0){
            System.out.println("Jumlah melebihi pinjaman!");
        } else if (angsurDulu < (jumlahPinjaman / 10)) {
            System.out.println("Maaf, angsuran harus 10% dari jumlah pinjaman");
        } else {
            jumlahPinjaman -= angsurDulu;
        }
    }
}
