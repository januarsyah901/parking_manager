import java.time.LocalDateTime;
// iki rasah di woco we, sesok ae tak ajari
public abstract class Kendaraan {
    private String nomorPlat; // gelem ra tak ajari
    private LocalDateTime waktuMasuk;

    public Kendaraan(String nomorPlat, LocalDateTime waktuMasuk) {
        this.nomorPlat = nomorPlat;
        this.waktuMasuk = waktuMasuk;
    }

    public String getNomorPlat() {
        return nomorPlat;
    }

    public LocalDateTime getWaktuMasuk() {
        return waktuMasuk;
    }

    // Metode abstrak untuk menghitung biaya parkir
    public abstract int hitungBiayaParkir();
}