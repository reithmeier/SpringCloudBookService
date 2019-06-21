package sve.project.ratingservice.domain;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.StringJoiner;

@Entity
public class Book {
    @Id
    private Long id;

    private String name;

    private Boolean deleted;

    @OneToMany
    private List<Rating> ratings;

    public Book() {
    }

    public Book(Long id, String name, Boolean deleted) {
        this.id = id;
        this.name = name;
        this.deleted = deleted;
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

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Book.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("deleted=" + deleted)
                .toString();
    }
}
