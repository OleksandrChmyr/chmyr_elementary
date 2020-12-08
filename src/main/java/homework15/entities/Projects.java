package homework15.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "projects")
public class Projects {

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;
    private String Description;

    @ManyToMany(mappedBy = "projects")
    private Set<Client> clients;

    public Projects() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
