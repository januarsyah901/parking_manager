import java.time.LocalDateTime;
// seng tenan lek sinau
public class Mobil extends Kendaraan {
    public Mobil(String nomorPlat, LocalDateTime waktuMasuk) {
        super(nomorPlat, waktuMasuk);
    }

    @Override
    public int hitungBiayaParkir() {
        long lamaParkir = java.time.Duration.between(getWaktuMasuk(), LocalDateTime.now()).toHours();
        return (int) (lamaParkir * 5000); // Tarif Rp5.000 per jam
    }
}