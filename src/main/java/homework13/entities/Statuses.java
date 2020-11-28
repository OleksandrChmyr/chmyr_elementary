package homework13.entities;

import java.util.Objects;

public class Statuses {

    private int id;
    private String alias;
    private String description;


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
