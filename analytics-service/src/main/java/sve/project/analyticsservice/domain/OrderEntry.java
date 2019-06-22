package sve.project.analyticsservice.domain;

import java.util.StringJoiner;


public class OrderEntry {

    private Long id;

    private Long book;

    private Long user;

    private String date;

    public OrderEntry() {
    }

    public OrderEntry(Long id, Long book, Long user, String date) {
        this.id = id;
        this.book = book;
        this.user = user;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBook() {
        return book;
    }

    public void setBook(Long book) {
        this.book = book;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", OrderEntry.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("book=" + book)
                .add("user=" + user)
                .add("date='" + date + "'")
                .toString();
    }
}
