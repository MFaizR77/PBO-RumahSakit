import java.util.Scanner;
import java.util.List;

public class RumahSakit {

    private static final int BIAYA_UMUM = 50_000;
    private static final int BIAYA_THT = 75_000;
    private static final int BIAYA_DALAM = 100_000;

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
            String nama = inputString(sc, "👤 Nama Lengkap Pasien : ");
            String penyakit = inputString(sc, "🩺 Keluhan/Penyakit     : ");
            int umur = inputInteger(sc, "🎂 Umur Pasien          : ", 1, 120);

            // Buat objek pasien
            Pasien pasien = new Pasien(nama, penyakit, umur);

            // Tentukan dokter sesuai penyakit
            Dokter dokterTujuan;
            int biaya = 0;

            if (termasukKeluhanUmum(penyakit)) {
                dokterTujuan = dokterUmum;
                biaya = BIAYA_UMUM;
            } else if (termasukKeluhanTHT(penyakit)) {
                dokterTujuan = dokterTHT;
                biaya = BIAYA_THT;
            } else {
                dokterTujuan = dokterDalam;
                biaya = BIAYA_DALAM;
            }


            // Proses pemeriksaan
            dokterTujuan.periksaPasien(pasien);

            // Proses pembayaran
            System.out.println("\n" + "💳 PEMBAYARAN".indent(4));
            System.out.printf("💰 Total Biaya: Rp %,d\n", biaya);
            System.out.print("Konfirmasi pembayaran? (y/n): ");
            String konfirmasi = sc.nextLine();
            if (konfirmasi.equalsIgnoreCase("y")) {
                Pembayaran pembayaran = new Pembayaran(biaya);
                System.out.println("✅ Pembayaran berhasil. Terima kasih!");
                pembayaran.bayar(pasien, dokterTujuan);
            } else {
                System.out.println("❌ Pembayaran dibatalkan.");
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

    private static String inputString(Scanner sc, String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("❌ Nama/keluhan tidak boleh kosong. Silakan isi kembali.");
            }
        } while (input.isEmpty());
        return input;
    }

    private static int inputInteger(Scanner sc, String prompt, int min, int max) {
        int nilai = 0;
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print(prompt);
                nilai = Integer.parseInt(sc.nextLine().trim());
                if (nilai < min || nilai > max) {
                    System.out.printf("❌ Umur harus antara %d dan %d tahun.\n", min, max);
                } else {
                    valid = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Input tidak valid. Harap masukkan angka.");
            }
        }
        return nilai;
    }

    private static boolean termasukKeluhanUmum(String penyakit) {
        return List.of("flu", "demam", "batuk", "pilek", "sakit kepala", "mual", "sakit perut", "gejala ringan")
                .contains(penyakit.toLowerCase());
    }

    private static boolean termasukKeluhanTHT(String penyakit) {
        return List.of("telinga", "hidung", "tenggorokan", "tht", "sinusitis", "amandel", "radang", "suara serak")
                .contains(penyakit.toLowerCase());
    }
}
