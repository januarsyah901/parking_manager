import java.time.LocalDateTime;
// sinau bel sinau
public class Motor extends Kendaraan {
    public Motor(String nomorPlat, LocalDateTime waktuMasuk) {
        super(nomorPlat, waktuMasuk);
    }

    @Override
    public int hitungBiayaParkir() {
        long lamaParkir = java.time.Duration.between(getWaktuMasuk(), LocalDateTime.now()).toHours();
        return (int) (lamaParkir * 2000); // Tarif Rp2.000 per jam
    }
}
