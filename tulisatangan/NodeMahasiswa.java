public class NodeMahasiswa {
    String nim, nama, jurusan;
    char nilai;
    NodeMahasiswa next;

    public NodeMahasiswa(String n, String nm, String j, char ni) {
        nim = n;
        nama = nm;
        jurusan = j;
        nilai = ni;
        next = null;
    }
}
