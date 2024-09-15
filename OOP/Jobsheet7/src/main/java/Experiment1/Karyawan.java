package Experiment1;

public class Karyawan {
    public String nama, alamat, jK;
    public int umur, gaji;

    public Karyawan(){
    }

    public Karyawan(String nama, String alamat, String jK, int umur, int gaji){
        this.nama = nama;
        this.alamat = alamat;
        this.jK = jK;
        this.umur = umur;
        this.gaji = gaji;
    }

    public void tampilDataKaryawan(){
        System.out.println("Nama          ="+nama);
        System.out.println("Alamat        ="+alamat);
        System.out.println("Jenis Kelamin ="+jK);
        System.out.println("Umur          ="+umur);
        System.out.println("Gaji          ="+gaji);
    }
}
