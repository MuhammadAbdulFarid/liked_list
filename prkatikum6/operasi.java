public class operasi {
    Rantai head;

    public void sisip(int data) {
        Rantai nodeBaru = new Rantai();
        nodeBaru.isi = data;
        nodeBaru.next = null;

        if (head == null) {
            head = nodeBaru;
        } else {
            Rantai nodeBantuan = head;
            while (nodeBantuan.next != null) {
                nodeBantuan = nodeBantuan.next;
            }
            nodeBantuan.next = nodeBaru;
        }
    }

    public void sisip_tengah(int data, int posisi) {
        Rantai nodeBaru = new Rantai();
        nodeBaru.isi = data;
        nodeBaru.next = null;

        if (posisi == 0) {
            sisip_depan(data);
        } else {
            Rantai nodeBantuan = head;
            for (int i = 1; i < posisi - 1; i++) {
                nodeBantuan = nodeBantuan.next;
            }
            nodeBaru.next = nodeBantuan.next;
            nodeBantuan.next = nodeBaru;
        }
    }

    public void sisip_depan(int data) {
        Rantai nodeBaru = new Rantai();
        nodeBaru.isi = data;
        nodeBaru.next = null;

        if (head == null) {
            head = nodeBaru;
        } else {
            nodeBaru.next = head;
            head = nodeBaru;
        }
    }

    public void hapus(int posisi) {
        Rantai nodeBantuan = head;
        Rantai nodeHapus = null;

        for (int i = 1; i < posisi - 1; i++) {
            nodeBantuan = nodeBantuan.next;
        }

        nodeHapus = nodeBantuan.next;
        nodeBantuan.next = nodeHapus.next;
        nodeHapus.next = null;
    }

    public void tampil() {
        Rantai nodeBantuan = head;
        while (nodeBantuan != null) {
            System.out.print(nodeBantuan.isi + " ");
            nodeBantuan = nodeBantuan.next;
        }
        System.out.println();
    }
}