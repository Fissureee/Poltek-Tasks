package Experiment1;

public class Inheritance1{
    public static void main(String[] args) {
//        Manager M = new Manager();
//        M.nama="Vivin";
//        M.alamat="Jl. Vinolia";
//        M.umur = 25;
//        M.jK = "Perempuan";
//        M.gaji = 3_000_000;
//        M.tunjangan = 1_000_000;
//        M.tampilDataManager();
//
//        Staff S = new Staff();
//        S.nama = "Lestari";
//        S.alamat = "Malang";
//        S.umur = 25;
//        S.jK = "Perempuan";
//        S.gaji = 2_000_000;
//        S.lembur = 500_000;
//        S.potongan = 250_000;
//        S.tampilDataStaff();



        //experiment2
        StaffTetap ST = new StaffTetap("Budi", "Malang", "Lakilaki", 20, 2_000_000, 250_000, 200_000, "2A", 100_000);
        ST.tampilStaffTetap();

        StaffHarian SH = new StaffHarian("Indah", "Malang", "Perempuan", 27, 10_000, 100_000, 50_000, 100);
        SH.tampilStaffHarian();
    }
}
