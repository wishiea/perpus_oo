package perpus;

import java.util.*;

public class Library {
    private Map<String, Book> books = new HashMap<>();
    private Map<String, Member> members = new HashMap<>();

    public void addBook(Book b) {
        books.put(b.getId(), b);
    }

    public void registerMember(Member m) {
        members.put(m.getMemberId(), m);
    }

    public List<Book> listAvailableBooks() {
        List<Book> available = new ArrayList<>();
        for (Book b : books.values()) {
            if (!b.isBorrowed()) {
                available.add(b);
            }
        }
        return available;
    }

    public void borrowBook(String memberId, String bookId) {
        Member m = members.get(memberId);
        Book b = books.get(bookId);

        if (m == null)
            throw new IllegalArgumentException("Member tidak ditemukan: " + memberId);
        if (b == null)
            throw new IllegalArgumentException("Book tidak ditemukan: " + bookId);
        if (b.isBorrowed())
            throw new IllegalStateException("Book sudah dipinjam: " + bookId);

        b.borrow();
        m.borrowBook(bookId);
    }

    public void returnBook(String memberId, String bookId) {
        Member m = members.get(memberId);
        Book b = books.get(bookId);

        if (m == null)
            throw new IllegalArgumentException("Member tidak ditemukan: " + memberId);
        if (b == null)
            throw new IllegalArgumentException("Book tidak ditemukan: " + bookId);
        if (!b.isBorrowed())
            throw new IllegalStateException("Book belum dipinjam: " + bookId);

        b.giveBack();
        m.returnBook(bookId);
    }
}
