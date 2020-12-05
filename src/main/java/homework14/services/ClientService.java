package homework14.services;

import homework14.entities.Client;

public interface ClientService {

    void save (Client client);
    void update (Client client);
    void delete (Client client);
    Client getById(int id);
    Client getByPhone(long phone);
}
