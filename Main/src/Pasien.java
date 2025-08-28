public class Pasien {
    private String nama;
    private String penyakit;
    private int umur;

    public Pasien(String nama, String penyakit, int umur) {
        this.nama = nama;
        this.penyakit = penyakit;
        this.umur = umur;
    }

    public String getNama() {
        return nama;
    }

    public String getPenyakit() {
        return penyakit;
    }

    public int getUmur() {
        return umur;
    }

    public String getKategoriUmur() {
        if (umur < 12) return "Anak-anak";
        if (umur < 18) return "Remaja";
        if (umur < 60) return "Dewasa";
        return "Lansia";
    }
}
