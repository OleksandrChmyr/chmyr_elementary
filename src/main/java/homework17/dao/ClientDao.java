package homework17.dao;

import homework17.entities.Client;

public interface ClientDao {

    void save (Client client);
    void update (Client client);
    void delete (Client client);
    Client getById(int id);
    Client getByPhone(long phone);


}
