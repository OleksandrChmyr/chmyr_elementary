package homework14.services;

import homework14.dao.ClientDao;
import homework14.dao.ClientDaoImpl;
import homework14.entities.Client;

public class ClientServiceImpl implements ClientService{
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
