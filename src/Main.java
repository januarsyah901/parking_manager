import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) { // lek koe gae intelij, harus e onk tombol play, iku petek en
        Scanner scanner = new Scanner(System.in);
        System.out.print("  _                    _    _          _   _   _             _ _ \n" +
                " | |__  _   _   _     / \\  | |__   ___| | | | | | __ _  __ _| | |\n" +
                " | '_ \\| | | | (_)   / _ \\ | '_ \\ / _ \\ | | | | |/ _` |/ _` | | |\n" +
                " | |_) | |_| |  _   / ___ \\| |_) |  __/ | | |_| | (_| | (_| | | |\n" +
                " |_.__/ \\__, | (_) /_/   \\_\\_.__/ \\___|_|  \\___/ \\__, |\\__,_|_|_|\n" +
                "        |___/                                    |___/           \n");
        System.out.print("Masukkan jumlah maksimal slot parkir: ");
        int maxSlot = scanner.nextInt();
        ParkirManager parkirManager = new ParkirManager(maxSlot);

        while (true) { // pak abel nakal
            System.out.println("\nMenu Utama:");
            System.out.println("1. Lihat Status Parkir");
            System.out.println("2. Tambah Kendaraan");
            System.out.println("3. Keluarkan Kendaraan");
            System.out.println("4. Exit");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
// rung sunat se koyok e
            switch (pilihan) {
                case 1:
                    parkirManager.lihatStatusParkir();
                    break;
                case 2:
                    System.out.print("Masukkan nomor plat: ");
                    String nomorPlat = scanner.next();
                    System.out.print("Masukkan jenis kendaraan (Mobil/Motor): ");
                    String jenis = scanner.next();
                    System.out.print("Masukkan waktu masuk (yyyy-MM-dd HH:mm): ");
                    scanner.nextLine(); // Membersihkan buffer
                    String waktuMasukStr = scanner.nextLine();
                    LocalDateTime waktuMasuk = LocalDateTime.parse(waktuMasukStr, java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

                    if (jenis.equalsIgnoreCase("Mobil")) {
                        parkirManager.tambahKendaraan(new Mobil(nomorPlat, waktuMasuk));
                    } else if (jenis.equalsIgnoreCase("Motor")) {
                        parkirManager.tambahKendaraan(new Motor(nomorPlat, waktuMasuk));
                    } else {
                        System.out.println("Jenis kendaraan tidak valid!");
                    }
                    break;
                case 3:
                    System.out.print("Masukkan nomor plat kendaraan yang akan keluar: ");
                    String platKeluar = scanner.next();
                    parkirManager.keluarkanKendaraan(platKeluar);
                    break;
                case 4:
                    parkirManager.tampilkanTotal();
                    System.out.println("Program selesai.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
}