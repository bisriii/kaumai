import java.util.Scanner;

public class bisri {

    // Inisialisasi data user (NIM dan password)
    private static final String ADMIN_NIM = "admin";
    private static final String ADMIN_PASSWORD = "admin123";
    private static final String MAHASISWA_NIM = "123456789012345";

    public static void main(String[] args) {
        // Membuat objek LibrarySystem
        bisri librarySystem = new bisri();

        // Menjalankan program
        librarySystem.run();
    }

    public void run() {
        // Membuat objek Scanner untuk input pengguna
        Scanner scanner = new Scanner(System.in);

        // Inisialisasi variabel untuk pilihan user
        String userType;

        do {
            // Menampilkan menu utama
            System.out.println("\n=== Menu Utama ===");
            System.out.println("1. Login");
            System.out.println("2. Keluar");

            // Meminta input dari pengguna
            System.out.print("Masukkan pilihan (1/2): ");
            userType = scanner.nextLine();

            // Proses pilihan user
            switch (userType) {
                case "1":
                    login(scanner);
                    break;
                case "2":
                    System.out.println("Terima kasih. Program keluar.");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia. Silakan pilih kembali.");
            }
        } while (!userType.equals("2"));

        // Menutup Scanner
        scanner.close();
    }

    private void login(Scanner scanner) {
        // Inisialisasi variabel untuk pilihan login
        String loginType;

        do {
            // Menampilkan menu login
            System.out.println("\n=== Menu Login ===");
            System.out.println("1. Admin Login");
            System.out.println("2. Mahasiswa Login");
            System.out.println("3. Kembali ke Menu Utama");

            // Meminta input dari pengguna
            System.out.print("Masukkan pilihan (1/2/3): ");
            loginType = scanner.nextLine();

            // Proses pilihan login
            switch (loginType) {
                case "1":
                    adminLogin(scanner);
                    break;
                case "2":
                    mahasiswaLogin(scanner);
                    break;
                case "3":
                    System.out.println("Kembali ke Menu Utama.");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia. Silakan pilih kembali.");
            }
        } while (!loginType.equals("3"));
    }

    private void adminLogin(Scanner scanner) {
        // Meminta input NIM dan password admin
        System.out.print("Masukkan NIM admin: ");
        String nim = scanner.nextLine();
        System.out.print("Masukkan password admin: ");
        String password = scanner.nextLine();

        // Memeriksa kecocokan NIM dan password admin
        if (nim.equals(ADMIN_NIM) && password.equals(ADMIN_PASSWORD)) {
            System.out.println("Login admin berhasil.");
        } else {
            System.out.println("Login admin gagal. Cek kembali NIM dan password.");
        }
    }

    private void mahasiswaLogin(Scanner scanner) {
        // Meminta input NIM mahasiswa
        System.out.print("Masukkan NIM mahasiswa: ");
        String nim = scanner.nextLine();

        // Memeriksa panjang NIM
        if (nim.length() == 15) {
            System.out.println("Login mahasiswa berhasil.");
        } else {
            System.out.println("Login mahasiswa gagal. Panjang NIM tidak boleh lebih dari 15 karakter.");
        }
    }
}
