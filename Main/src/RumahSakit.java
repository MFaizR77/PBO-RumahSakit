import java.util.Scanner;

public class RumahSakit {
    public static void main(String[] args) {
        System.out.println("🏥 SELAMAT DATANG DI RUMAH SAKIT ABC 🏥");
        System.out.println("=" .repeat(50));
        Scanner sc = new Scanner(System.in);

        // Daftar Dokter
        Dokter dokterUmum = new Dokter("Dr. Andi", "Umum");
        Dokter dokterTHT = new Dokter("Dr. Siti", "THT");
        Dokter dokterDalam = new Dokter("Dr. Budi", "Penyakit Dalam");

        boolean jalan = true;

        while (jalan) {

            TampilkanMenuUtama();

            System.out.println("\n=== Rumah Sakit ===");
            System.out.print("👤 Nama Lengkap Pasien : ");
            String nama = sc.nextLine();

            System.out.print("🩺 Keluhan/Penyakit     : ");
            String penyakit = sc.nextLine();

            System.out.print("🎂 Umur Pasien         : ");
            int umur = sc.nextInt();
            sc.nextLine();

            // Buat objek pasien
            Pasien pasien = new Pasien(nama, penyakit, umur);

            // Tentukan dokter sesuai penyakit
            Dokter dokterTujuan;
            int biaya = 0;

            if (penyakit.equalsIgnoreCase("flu") || penyakit.equalsIgnoreCase("demam")
                    || penyakit.equalsIgnoreCase("batuk") || penyakit.equalsIgnoreCase("pilek")
                    || penyakit.equalsIgnoreCase("sakit kepala")|| penyakit.equalsIgnoreCase("mual")) {
                dokterTujuan = dokterUmum;
                biaya = 50000;
            } else if (penyakit.equalsIgnoreCase("telinga") || penyakit.equalsIgnoreCase("hidung")
                    || penyakit.equalsIgnoreCase("tenggorokan")|| penyakit.equalsIgnoreCase("tht")
                    || penyakit.equalsIgnoreCase("sinusitis")|| penyakit.equalsIgnoreCase("amandel")) {
                dokterTujuan = dokterTHT;
                biaya = 75000;
            } else {
                dokterTujuan = dokterDalam;
                biaya = 100000;
            }

            // Proses pemeriksaan
            dokterTujuan.periksaPasien(pasien);

            // Proses pembayaran
            System.out.print("Total pembayaran: " + biaya + "\n");
            System.out.print("Konfirmansi pembayaran? (y): ");
            String konfirmasi = sc.nextLine();
            if (konfirmasi.equalsIgnoreCase("y")) {
                Pembayaran pembayaran = new Pembayaran(biaya);
                pembayaran.bayar(pasien, dokterTujuan);
            }


            // Tanya mau input lagi atau tidak
            System.out.print("Apakah mau input pasien lagi? (y/n): ");
            String lagi = sc.nextLine();

            if (lagi.equalsIgnoreCase("n")) {
                jalan = false;
            }
        }

        System.out.println("Terima kasih telah menggunakan sistem Rumah Sakit.");
        sc.close();
    }

    private static void TampilkanMenuUtama(){
        System.out.println("\n📋 PENDAFTARAN PASIEN BARU");
        System.out.println("=" .repeat(30));
    }

}
