import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class codelab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input Nama
        System.out.print("Nama : ");
        String nama = scanner.nextLine();

        // Input Jenis Kelamin
        System.out.print("Jenis Kelamin (L/P) : ");
        char jenisKelamin = scanner.next().charAt(0);

        // Input Tanggal Lahir
        System.out.print("Tanggal Lahir (tahun-bulan-tanggal) : ");
        String tanggalLahirStr = scanner.next();

        // Konversi tanggal lahir ke umur
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-mm-dd");
        try {
            Date tanggalLahir = sdf.parse(tanggalLahirStr);
            int umur = hitungUmur(tanggalLahir);

            // Output informasi
            System.out.println("Nama : " + nama);
            System.out.println("Jenis Kelamin: " + (jenisKelamin == 'P' ? "Perempuan" : "Laki-Laki"));
            System.out.println("Umur Anda: " + umur + " tahun " + hitungBulan(tanggalLahir) + " bulan");
        } catch (ParseException e) {
            System.out.println("Format tanggal lahir tidak valid. Gunakan format tahun-bulan-tanggal ");
        }
    }

    private static int hitungUmur(Date tanggalLahir) {
        Date tanggalSekarang = new Date();
        int umur = tanggalSekarang.getYear() - tanggalLahir.getYear();
        if (tanggalSekarang.getMonth() < tanggalLahir.getMonth() ||
                (tanggalSekarang.getMonth() == tanggalLahir.getMonth() && tanggalSekarang.getDate() < tanggalLahir.getDate())) {
            umur--;
        }
        return umur;
    }

    private static int hitungBulan(Date tanggalLahir) {
        Date tanggalSekarang = new Date();
        int bulan = 0;
        if (tanggalSekarang.getMonth() >= tanggalLahir.getMonth()) {
            bulan = tanggalSekarang.getMonth() - tanggalLahir.getMonth();
        } else {
            bulan = (12 + tanggalSekarang.getMonth()) - tanggalLahir.getMonth();
        }
        return bulan;
    }
}
