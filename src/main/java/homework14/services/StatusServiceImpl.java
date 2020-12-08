package homework14.services;

import homework14.dao.StatusesDao;
import homework14.dao.StatusesDaoImpl;
import homework14.entities.Statuses;

public class StatusServiceImpl implements StatusService{
    @Override
    public void save(Statuses statuses) {
        StatusesDao statusesDao = new StatusesDaoImpl();
        statusesDao.save(statuses);

    }

    @Override
    public void update(Statuses statuses) {
        StatusesDao statusesDao = new StatusesDaoImpl();
        statusesDao.update(statuses);
    }

    @Override
    public void delete(Statuses statuses) {
        StatusesDao statusesDao = new StatusesDaoImpl();
        statusesDao.delete(statuses);
    }

    @Override
    public Statuses getById(int id) {
        StatusesDao statusesDao = new StatusesDaoImpl();
        return statusesDao.getById(id);
    }
}
