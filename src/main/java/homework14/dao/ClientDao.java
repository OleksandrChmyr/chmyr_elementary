package homework14.dao;

import homework14.entities.Client;

public interface ClientDao {

    void save (Client client);
    void update (Client client);
    void delete (Client client);
    Client getById(int id);
    Client getByPhone(long phone);


}
