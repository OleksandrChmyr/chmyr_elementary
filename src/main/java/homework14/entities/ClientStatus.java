package homework14.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table (name = "client_status")
public class ClientStatus {

    @Column(nullable = false)
    private int statusID;
    @Column(nullable = false)
    private int clientID;

    public ClientStatus() {
    }

    public ClientStatus(int clientID, int statusID) {
        this.clientID = clientID;
        this.statusID = statusID;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public int getStatusID() {
        return statusID;
    }

    public void setStatusID(int statusID) {
        this.statusID = statusID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientStatus that = (ClientStatus) o;
        return clientID == that.clientID &&
                statusID == that.statusID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientID, statusID);
    }

    @Override
    public String toString() {
        return "ClientStatus{" +
                "clientID=" + clientID +
                ", statusID=" + statusID +
                '}';
    }
}
