package sve.project.bookservice.domain;


import javax.persistence.*;
import java.util.StringJoiner;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    private Author author;

    @ManyToOne
    private Publisher publisher;

    public Book() {
    }

    public Book(String name, Author author, Publisher publisher) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Book.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("author=" + author)
                .add("publisher=" + publisher)
                .toString();
    }
}
