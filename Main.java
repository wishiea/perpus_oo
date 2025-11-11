package perpus;

public class Main {
    public static void main(String[] args) {
        Library lib = new Library();

        lib.addBook(new Book("B001", "Dasar Pemrograman Java", "A. Programmer"));
        lib.addBook(new Book("B002", "Algoritma dan Struktur Data", "B. Algorithm"));
        lib.addBook(new Book("B003", "Basis Data", "C. DBase"));

        lib.registerMember(new Member("M001", "Budi"));
        lib.registerMember(new Member("M002", "Siti"));

        System.out.println("=== Daftar Buku Tersedia (Awal) ===");
        for (Book b : lib.listAvailableBooks()) {
            System.out.println(b);
        }

        lib.borrowBook("M001", "B001");
        System.out.println("\nSetelah Budi meminjam B001:");
        for (Book b : lib.listAvailableBooks()) {
            System.out.println(b);
        }

        lib.returnBook("M001", "B001");
        System.out.println("\nSetelah Budi mengembalikan B001:");
        for (Book b : lib.listAvailableBooks()) {
            System.out.println(b);
        }
    }
}
