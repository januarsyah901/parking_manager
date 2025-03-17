import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
// bel
// dadi ngene lek koe pengen run ya, kudu di run file Main.java
public class ParkirManager {
    private List<Kendaraan> slotParkir;
    private int maxSlot;
    private int totalPendapatan;
    private int totalKendaraanKeluar;

    public ParkirManager(int maxSlot) {
        this.maxSlot = maxSlot;
        this.slotParkir = new ArrayList<>(maxSlot);
        for (int i = 0; i < maxSlot; i++) {
            slotParkir.add(null); // Inisialisasi slot parkir kosong
        }
        this.totalPendapatan = 0;
        this.totalKendaraanKeluar = 0;
    }

    // Menampilkan status parkir
    public void lihatStatusParkir() {
        System.out.println("\nStatus Parkir:");
        for (int i = 0; i < maxSlot; i++) {
            Kendaraan kendaraan = slotParkir.get(i);
            if (kendaraan != null) {
                System.out.println("Slot " + i + ": " + kendaraan.getNomorPlat() + " (" + kendaraan.getClass().getSimpleName() + ")");
            } else {
                System.out.println("Slot " + i + ": Kosong");
            }
        }
    }

    // Menambahkan kendaraan
    public void tambahKendaraan(Kendaraan kendaraan) {
        int slotKosong = -1;
        for (int i = 0; i < maxSlot; i++) {
            if (slotParkir.get(i) == null) {
                slotKosong = i;
                break;
            }
        }

        if (slotKosong == -1) {
            System.out.println("Parkiran penuh!");
            return;
        }

        // Validasi penempatan Mobil dan Motor
        if (kendaraan instanceof Mobil) {
            for (int i = 0; i < slotKosong; i++) {
                if (slotParkir.get(i) instanceof Motor) {
                    System.out.println("Mobil tidak boleh ditempatkan di bawah Motor!");
                    return;
                }
            }
        }

        slotParkir.set(slotKosong, kendaraan);
        System.out.println("Kendaraan berhasil ditambahkan di slot " + slotKosong);
    }

    // Mengeluarkan kendaraan
    public void keluarkanKendaraan(String nomorPlat) {
        for (int i = 0; i < maxSlot; i++) {
            Kendaraan kendaraan = slotParkir.get(i);
            if (kendaraan != null && kendaraan.getNomorPlat().equals(nomorPlat)) {
                int biaya = kendaraan.hitungBiayaParkir();
                totalPendapatan += biaya;
                totalKendaraanKeluar++;
                slotParkir.set(i, null);
                System.out.println("Kendaraan berhasil keluar. Total biaya: Rp" + biaya);
                return;
            }
        }
        System.out.println("Kendaraan dengan nomor plat " + nomorPlat + " tidak ditemukan.");
    }

    // Menampilkan total pendapatan dan kendaraan keluar
    public void tampilkanTotal() {
        if (totalKendaraanKeluar == 0) {
            System.out.println("Parkiran sepi hari ini, semoga besok lebih ramai.");
        } else {
            System.out.println("Total kendaraan keluar: " + totalKendaraanKeluar);
            System.out.println("Total pendapatan parkir: Rp" + totalPendapatan);
        }
    }
}