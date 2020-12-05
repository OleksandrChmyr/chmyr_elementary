package homework15.services;

import homework15.dao.ClientDao;
import homework15.dao.ClientDaoImpl;
import homework15.entities.Client;

public class ClientServiceImpl implements ClientService {
    @Override
    public void save(Client client) {
        ClientDao clientDao = new ClientDaoImpl();
        clientDao.save(client);
    }

    @Override
    public void update(Client client) {
        ClientDao clientDao = new ClientDaoImpl();
        clientDao.update(client);

    }

    @Override
    public void delete(Client client) {
        ClientDao clientDao = new ClientDaoImpl();
        clientDao.delete(client);
    }

    @Override
    public Client getById(int id) {
        ClientDao clientDao = new ClientDaoImpl();
        return clientDao.getById(id);
    }

    @Override
    public Client getByPhone(long phone) {
        ClientDao clientDao = new ClientDaoImpl();
        return clientDao.getByPhone(phone);
    }
}
