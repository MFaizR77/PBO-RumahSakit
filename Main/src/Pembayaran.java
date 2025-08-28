public class Pembayaran {
    private int biaya;

    public Pembayaran(int biaya) {
        this.biaya = biaya;
    }

    public int getBiaya() {
        return biaya;
    }

    public void bayar(Pasien pasien, Dokter dokter) {
        System.out.println("Pasien " + pasien.getNama() + " membayar biaya sebesar Rp" + biaya);
        System.out.println("\n" + "=".repeat(40));
        System.out.println("           STRUK PEMBAYARAN");
        System.out.println("           RUMAH SAKIT ABC");
        System.out.println("=".repeat(40));
        System.out.println("-".repeat(40));
        System.out.println("Nama Pasien   : " + pasien.getNama());
        System.out.println("Umur Pasien   : " + pasien.getUmur());
        System.out.println("Kategori Pasien: " + pasien.getKategoriUmur());
        System.out.println("Penyakit      : " + pasien.getPenyakit());
        System.out.println("Dokter        : " + dokter.getNamaDokter());
        System.out.println("Spesialis     : " + dokter.getSpesialis());
        System.out.println("-".repeat(40));
        System.out.println("Biaya Konsultasi : Rp" + biaya);
        System.out.println("Status         : LUNAS");
        System.out.println("=".repeat(40));
        System.out.println("    Terima kasih atas kunjungan Anda");
        System.out.println("         Semoga lekas sembuh!");
        System.out.println("=".repeat(40));
    }
}
