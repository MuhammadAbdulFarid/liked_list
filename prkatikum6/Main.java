public class Main {
    public static void main(String[] args) {
        // 1. Membuat objek dari kelas Operasi
        operasi list = new operasi();

        System.out.println("--- Menambah Data ---");

        // 2. Menggunakan sisip_depan
        list.sisip_depan(10); // List: 10

        // 3. Menggunakan sisip (tambah di belakang/ekor)
        list.sisip(20); // List: 10, 20
        list.sisip(40); // List: 10, 20, 40

        // 4. Menggunakan sisip_tengah
        // Kita masukkan angka 30 di posisi ke-3
        list.sisip_tengah(30, 3); // List: 10, 20, 30, 40

        System.out.print("Isi Linked List saat ini: ");
        list.tampil();

        System.out.println("\n--- Menghapus Data ---");

        // 5. Menggunakan hapus
        // Menghapus node di posisi ke-2 (angka 20)
        list.hapus(2);

        System.out.print("Isi Linked List setelah dihapus: ");
        list.tampil();
    }
}