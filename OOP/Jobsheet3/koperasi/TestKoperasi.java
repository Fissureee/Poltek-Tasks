package koperasi;

import java.util.Scanner;

public class TestKoperasi {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Anggota donny = new Anggota("111333444", "Donny", 5000000);
        System.out.println("Nama Anggota: " + donny.getNama());
        System.out.println("Limit Pinjaman: " + donny.getLimitPinjaman());

        int menu;
        do {
            System.out.println("========Menu Pinjaman=======");
            System.out.println("1. Pinjam  \n2. Angsur \n3. Jumlah Pinjaman \n4. Keluar");
            System.out.print("Masukkan Pilihan: ");
            menu = sc.nextInt();
            switch (menu){
                case 1:
                    System.out.println("Masukkan jumlah pinjaman: ");
                    donny.pinjam(sc.nextInt());
                    System.out.println("Jumlah pinjaman saat ini: " + donny.getJumlahPinjaman());
                    break;

                case 2:
                    System.out.println("Masukkan jumlah angsuran: ");
                    donny.angsur(sc.nextInt());
                    System.out.println("Jumlah pinjaman saat ini: " + donny.getJumlahPinjaman());
                    break;

                case 3:
                    System.out.println("Jumlah pinjaman saat ini: " + donny.getJumlahPinjaman());
                    break;
            }
        } while(menu > 0 && menu < 4);

    }
}
