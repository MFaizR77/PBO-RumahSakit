    public class Dokter {
        private String namaDokter;
        private String spesialis;

        public Dokter(String namaDokter, String spesialis) {
            this.namaDokter = namaDokter;
            this.spesialis = spesialis;
        }

        public String getNamaDokter() {
            return namaDokter;
        }

        public String getSpesialis() {
            return spesialis;
        }

        public void periksaPasien(Pasien pasien) {
            System.out.println("Dokter " + namaDokter + " (Spesialis " + spesialis +
                    ") sedang memeriksa pasien " + pasien.getNama() + " dengan penyakit " + pasien.getPenyakit());
        }
    }
