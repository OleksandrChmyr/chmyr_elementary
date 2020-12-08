package homework15.dao;

import homework15.entities.Client;

public interface ClientDao {

    void save (Client client);
    void update (Client client);
    void delete (Client client);
    Client getById(int id);
    Client getByPhone(long phone);


}
