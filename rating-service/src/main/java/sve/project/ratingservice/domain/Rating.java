package sve.project.ratingservice.domain;

import javax.persistence.*;
import java.util.StringJoiner;

@Entity
public class Rating {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private int value;

    @ManyToOne
    private Book book;

    @ManyToOne
    private User user;

    public Rating() {
    }

    public Rating(int value, Book book, User user) {
        this.value = value;
        this.book = book;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
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
        return new StringJoiner(", ", Rating.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("value=" + value)
                .add("book=" + book)
                .add("user=" + user)
                .toString();
    }
}
