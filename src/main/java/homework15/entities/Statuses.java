package homework15.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table (name = "statuses")
public class Statuses {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(length = 15, unique = true, nullable = false)
    private String alias;
    @Column(nullable = false)
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Client client;


    public Statuses() {
    }

    public Statuses(int id, String alias, String description) {
        this.id = id;
        this.alias = alias;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Statuses statuses = (Statuses) o;
        return id == statuses.id &&
                Objects.equals(alias, statuses.alias) &&
                Objects.equals(description, statuses.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, alias, description);
    }

    @Override
    public String toString() {
        return "Statuses{" +
                "id=" + id +
                ", alias='" + alias + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
