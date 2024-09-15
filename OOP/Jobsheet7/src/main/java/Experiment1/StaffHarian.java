package Experiment1;

public class StaffHarian extends Staff{
    public int jmlJamKerja;

    public StaffHarian(){

    }

    public StaffHarian(String nama, String alamat, String jK, int umur, int gaji, int lembur, int potongan, int jmlJamKerja){
        super(nama, alamat, jK, umur, gaji, lembur, potongan);
        this.jmlJamKerja=jmlJamKerja;
    }
    public void tampilStaffHarian(){
        System.out.println("===========================Data Staff Harian=========================");
        super.tampilDataStaff();
        System.out.println("Jumlah Jam Kerja ="+jmlJamKerja);
        System.out.println("Gaji Bersih      ="+(gaji*jmlJamKerja+lembur-potongan));
    }
}
