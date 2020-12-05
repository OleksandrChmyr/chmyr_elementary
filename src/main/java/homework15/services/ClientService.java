package homework15.services;

import homework15.entities.Client;

public interface ClientService {

    void save (Client client);
    void update (Client client);
    void delete (Client client);
    Client getById(int id);
    Client getByPhone(long phone);
}
