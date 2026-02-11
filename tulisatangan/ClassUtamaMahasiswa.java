import java.util.Scanner;

public class ClassUtamaMahasiswa {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        OperasiMahasiswa op = new OperasiMahasiswa();

        System.out.print("Jumlah mahasiswa : ");
        int n = input.nextInt();
        input.nextLine();

        for (int i = 1; i <= n; i++) {
            System.out.println("\nMahasiswa ke-" + i);

            System.out.print("NIM     : ");
            String nim = input.nextLine();

            System.out.print("Nama    : ");
            String nama = input.nextLine();

            System.out.print("Jurusan : ");
            String jurusan = input.nextLine();

            System.out.print("Nilai   : ");
            char nilai = input.nextLine().toUpperCase().charAt(0);

            op.sisip_belakang(
                    new NodeMahasiswa(nim, nama, jurusan, nilai));
        }

        int pilih;
        do {
            System.out.println("\n1. Ascending (E -> A)");
            System.out.println("2. Descending (A -> E)");
            System.out.print("Pilih : ");
            pilih = input.nextInt();

            if (pilih != 1 && pilih != 2) {
                System.out.println("\nPilihan tidak valid!");
                System.out.println("Silahkan pilih kembali (1 atau 2).");
            }
        } while (pilih != 1 && pilih != 2);

        System.out.println("\n=== PROSES PENGURUTAN ===");
        op.urutkanDenganProses(pilih);

        System.out.println("\n=== HASIL AKHIR ===");
        op.tampil("Linked List Terurut");

        System.out.println("\n=== DATA MAHASISWA TERURUT ===");
        op.tampilSemuaData();

        input.close();
    }
}
