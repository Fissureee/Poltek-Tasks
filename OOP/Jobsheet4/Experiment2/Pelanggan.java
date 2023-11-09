package Experiment2;

public class Pelanggan {
    private String nama;
    private Mobil mobil;
    private Sopir sopir;
    private int hari;

    public void setNama(String nama){
        this.nama = nama;
    }

    public void setMobil(Mobil mobil){
        this.mobil = mobil;
    }

    public void setSopir(Sopir sopir){
        this.sopir = sopir;
    }

    public void setHari(int hari){
        this.hari = hari;
    }

    public String getNama(){
        return nama;
    }

    public Mobil getMobil(){
        return mobil;
    }

    public Sopir getSopir(){
        return sopir;
    }

    public int getHari(){
        return hari;
    }

    public int hitungBiayaTotal(){
        return mobil.hitungBiayaMobil(hari) + sopir.hitungBiayaSopir(hari);
    }
}
