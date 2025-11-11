package perpus;

public class Book {
    private String id;
    private String title;
    private String author;
    private boolean borrowed;

    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.borrowed = false;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isBorrowed() { return borrowed; }

    public void borrow() {
        if (borrowed) {
            throw new IllegalStateException("Buku sudah dipinjam.");
        }
        borrowed = true;
    }

    public void giveBack() {
        if (!borrowed) {
            throw new IllegalStateException("Buku belum dipinjam.");
        }
        borrowed = false;
    }

    @Override
    public String toString() {
        return String.format("Book[id=%s, title=%s, author=%s, borrowed=%s]", 
                id, title, author, borrowed);
    }
}
