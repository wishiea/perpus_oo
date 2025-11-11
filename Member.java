package perpus;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String memberId;
    private String name;
    private List<String> borrowedBookIds = new ArrayList<>();

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    public String getMemberId() { return memberId; }
    public String getName() { return name; }

    public void borrowBook(String bookId) {
        borrowedBookIds.add(bookId);
    }

    public void returnBook(String bookId) {
        borrowedBookIds.remove(bookId);
    }

    public List<String> getBorrowedBookIds() {
        return new ArrayList<>(borrowedBookIds);
    }

    @Override
    public String toString() {
        return String.format("Member[id=%s, name=%s, borrowed=%s]", 
                memberId, name, borrowedBookIds);
    }
}
