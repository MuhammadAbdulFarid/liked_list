package tulis_tangan;

public class NodeMahasiswa {
    String nim;
    String nama;
    String nilai;
    NodeMahasiswa next;

    NodeMahasiswa(String nim, String nama, String nilai) {
        this.nim = nim;
        this.nama = nama;
        this.nilai = nilai;
        this.next = null;
    }
}

class LinkedListMahasiswa {
    NodeMahasiswa head;

    // Method menyisipkan data di depan (Head)
    void sisipDepan(String nim, String nama, String nilai) {
        NodeMahasiswa baru = new NodeMahasiswa(nim, nama, nilai);
        baru.next = head;
        head = baru;
    }

    // Method menyisipkan data di belakang (Tail)
    void sisipBelakang(String nim, String nama, String nilai) {
        NodeMahasiswa baru = new NodeMahasiswa(nim, nama, nilai);
        if (head == null) {
            head = baru;
            return;
        }
        NodeMahasiswa temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = baru;
    }

    // Method menyisipkan data di tengah berdasarkan posisi
    void sisipTengah(String nim, String nama, String nilai, int posisi) {
        if (posisi <= 1) {
            sisipDepan(nim, nama, nilai);
            return;
        }

        NodeMahasiswa baru = new NodeMahasiswa(nim, nama, nilai);
        NodeMahasiswa temp = head;

        // Loop untuk mencari posisi sebelum node yang dituju
        for (int i = 1; i < posisi - 1 && temp.next != null; i++) {
            temp = temp.next;
        }

        baru.next = temp.next;
        temp.next = baru;
    }

    // Method untuk menampilkan data
    void tampilData() {
        System.out.println("\n--- Data Mahasiswa ---");
        System.out.println("|NIM            |Nama                     |Nilai |");
        System.out.println("--------------------------------------------------");

        NodeMahasiswa temp = head;
        while (temp != null) {
            // Menggunakan format sesuai tulisan tangan: %-15s | %-25s | %-5s |
            System.out.printf("|%-15s | %-25s | %-5s |\n", temp.nim, temp.nama, temp.nilai);
            temp = temp.next;
        }
    }
}
