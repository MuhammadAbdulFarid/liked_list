public class OperasiMahasiswa {
    NodeMahasiswa head;

    int bobot(char n) {
        switch (n) {
            case 'A':
                return 4;
            case 'B':
                return 3;
            case 'C':
                return 2;
            case 'D':
                return 1;
            case 'E':
                return 0;
            default:
                return -1;
        }
    }

    String hasilBanding(char a, char b) {
        int ba = bobot(a);
        int bb = bobot(b);

        if (ba == bb) {
            return a + " sama dengan " + b;
        } else if (ba > bb) {
            return a + " lebih besar dari " + b;
        } else {
            return a + " lebih kecil dari " + b;
        }
    }

    public void sisip_belakang(NodeMahasiswa baru) {
        if (head == null) {
            head = baru;
        } else {
            NodeMahasiswa bantu = head;
            while (bantu.next != null) {
                bantu = bantu.next;
            }
            bantu.next = baru;
        }
    }

    public void sisip_depan(NodeMahasiswa baru) {
        baru.next = head;
        head = baru;
    }

    public void sisip_tengah(NodeMahasiswa prev, NodeMahasiswa baru) {
        baru.next = prev.next;
        prev.next = baru;
    }

    public void tampil(String judul) {
        System.out.print(judul + " : ");
        NodeMahasiswa bantu = head;
        while (bantu != null) {
            System.out.print(bantu.nilai + " ");
            bantu = bantu.next;
        }
        System.out.println();
    }

    public void urutkanDenganProses(int mode) {
        System.out.println("\n=== DATA LINKED LIST ===");
        tampil("Awal");

        NodeMahasiswa sorted = null;
        NodeMahasiswa current = head;
        head = null;

        int proses = 1;

        while (current != null) {
            NodeMahasiswa next = current.next;
            current.next = null;

            System.out.println("\nProses ke-" + proses);
            System.out.println("Data diproses: " + current.nilai);

            if (sorted == null) {
                System.out.println("List kosong -> sisip di DEPAN");
                sorted = current;
            } else {
                System.out.println("Bandingkan " + current.nilai + " dengan " +
                        sorted.nilai + " -> " + hasilBanding(current.nilai, sorted.nilai));

                boolean depan = (mode == 1)
                        ? bobot(current.nilai) < bobot(sorted.nilai)
                        : bobot(current.nilai) > bobot(sorted.nilai);

                if (depan) {
                    System.out.println("Sisip di DEPAN");
                    current.next = sorted;
                    sorted = current;
                } else {
                    NodeMahasiswa bantu = sorted;
                    boolean masuk = false;
                    int posisi = 1;

                    while (bantu.next != null) {
                        System.out.println("Bandingkan " + current.nilai +
                                " dengan " + bantu.next.nilai + " -> " + hasilBanding(current.nilai, bantu.next.nilai));

                        boolean tengah = (mode == 1)
                                ? bobot(current.nilai) < bobot(bantu.next.nilai)
                                : bobot(current.nilai) > bobot(bantu.next.nilai);

                        if (tengah) {
                            posisi++;
                            System.out.println("Sisip di TENGAH pada posisi ke-" + posisi);
                            current.next = bantu.next;
                            bantu.next = current;
                            masuk = true;
                            break;
                        }
                        bantu = bantu.next;
                        posisi++;
                    }

                    if (!masuk) {
                        System.out.println("Sisip di BELAKANG");
                        bantu.next = current;
                    }
                }
            }
            head = sorted;
            tampil("Kondisi setelah proses");
            current = next;
            proses++;
        }
    }

    public void tampilSemuaData() {
        NodeMahasiswa bantu = head;
        while (bantu != null) {
            System.out.println("NIM: " + bantu.nim + ", Nama: " +
                    bantu.nama + ", Jurusan: " + bantu.jurusan + ", Nilai: " + bantu.nilai);
            bantu = bantu.next;
        }
    }
}
