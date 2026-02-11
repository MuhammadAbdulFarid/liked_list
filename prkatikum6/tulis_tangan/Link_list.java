package tulis_tangan;

import java.util.Scanner;

public class Link_list {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Pastikan class LinkedListMahasiswa dari file sebelumnya sudah ada
        LinkedListMahasiswa list = new LinkedListMahasiswa();
        int menu;

        do {
            System.out.println("\n=== MENU UTAMA ===");
            System.out.println("1. Tambah Data Mahasiswa (Input Berulang)");
            System.out.println("2. Hapus Data");
            System.out.println("3. Keluar");
            System.out.print("Pilih Menu: ");

            menu = input.nextInt();
            input.nextLine(); // Membersihkan buffer enter

            switch (menu) {
                case 1:
                    System.out.print("\nBerapa jumlah yang ingin diinput?: ");
                    int jumlah = input.nextInt();
                    input.nextLine(); // Membersihkan buffer

                    for (int i = 1; i <= jumlah; i++) {
                        System.out.println("\n-------------------------");
                        System.out.println("INPUT DATA MAHASISWA KE-" + i);
                        System.out.println("-------------------------");

                        System.out.print("Masukkan NIM  : ");
                        String nim = input.nextLine();

                        System.out.print("Masukkan Nama : ");
                        String nama = input.nextLine();

                        System.out.print("Masukkan Nilai: ");
                        String nilai = input.nextLine();

                        System.out.println("\nIngin disisip di mana?");
                        System.out.println("1. Sisip Depan");
                        System.out.println("2. Sisip Tengah");
                        System.out.println("3. Sisip Belakang");
                        System.out.print("Pilih Posisi (1-3): ");
                        int posisi = input.nextInt();
                        input.nextLine(); // Membersihkan buffer

                        if (posisi == 1) {
                            list.sisipDepan(nim, nama, nilai);
                            System.out.println("Data " + nama + " berhasil disisip di depan.");
                        } else if (posisi == 2) {
                            System.out.print("Sisip pada urutan ke berapa?: ");
                            int urutan = input.nextInt();
                            input.nextLine(); // Buffer
                            list.sisipTengah(nim, nama, nilai, urutan);
                            System.out.println("Data " + nama + " berhasil disisip di posisi urutan " + urutan + ".");
                        } else if (posisi == 3) {
                            list.sisipBelakang(nim, nama, nilai);
                            System.out.println("Data " + nama + " berhasil disisip di belakang.");
                        }

                        // Menampilkan data setiap kali selesai input satu mahasiswa
                        list.tampilData();
                    }
                    break;

                case 2:
                    System.out.println("Fitur hapus data belum diimplementasikan.");
                    break;

                case 3:
                    System.out.println("Program Selesai.");
                    break;

                default:
                    System.out.println("Menu tidak valid!");
            }

        } while (menu != 3);
    }
}