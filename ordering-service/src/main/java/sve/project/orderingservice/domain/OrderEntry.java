package sve.project.orderingservice.domain;


import javax.persistence.*;
import java.util.StringJoiner;

@Entity
public class OrderEntry {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String date;

    @ManyToOne
    private Book book;

    @ManyToOne
    private User user;

    public OrderEntry() {
    }

    public OrderEntry(String date, Book book, User user) {
        this.date = date;
        this.book = book;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", OrderEntry.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("date=" + date)
                .add("book=" + book)
                .add("user=" + user)
                .toString();
    }
}
