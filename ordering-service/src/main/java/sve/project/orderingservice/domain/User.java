package sve.project.orderingservice.domain;


import javax.persistence.*;
import java.util.List;
import java.util.StringJoiner;

@Entity
public class User {
    @Id
    private Long id;

    private String name;

    private Boolean deleted;

    @OneToMany
    private List<OrderEntry> orderEntries;

    public User() {
    }

    public User(Long id, String name, Boolean deleted) {
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

    public List<OrderEntry> getOrderEntries() {
        return orderEntries;
    }

    public void setOrderEntries(List<OrderEntry> orderEntries) {
        this.orderEntries = orderEntries;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("deleted=" + deleted)
                .toString();
    }
}
