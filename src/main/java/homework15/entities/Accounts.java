package homework15.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table (name = "accounts")
public class Accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(nullable = false)
    private int clientId;
    @Column(length = 20, unique = true, nullable = false)
    private String number;
    @Column(nullable = false)
    private double value;

    @OneToOne(mappedBy = "account")
    private Client client;

    public Accounts() {
    }

    public Accounts(int id, int clientId, String number, double value) {
        this.id = id;
        this.clientId = clientId;
        this.number = number;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accounts accounts = (Accounts) o;
        return id == accounts.id &&
                clientId == accounts.clientId &&
                Double.compare(accounts.value, value) == 0 &&
                Objects.equals(number, accounts.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientId, number, value);
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", number='" + number + '\'' +
                ", value=" + value +
                '}';
    }
}
