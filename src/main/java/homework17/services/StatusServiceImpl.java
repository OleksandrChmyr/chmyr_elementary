package homework17.services;

import homework17.dao.StatusesDao;
import homework17.dao.StatusesDaoImpl;
import homework17.entities.Statuses;
import org.apache.log4j.Logger;

public class StatusServiceImpl implements StatusService{
    Logger logger = Logger.getLogger(StatusServiceImpl.class);

    @Override
    public void save(Statuses statuses) {
        logger.debug(statuses.toString());
        StatusesDao statusesDao = new StatusesDaoImpl();
        statusesDao.save(statuses);

    }

    @Override
    public void update(Statuses statuses) {
        logger.debug(statuses.toString());
        StatusesDao statusesDao = new StatusesDaoImpl();
        statusesDao.update(statuses);
    }

    @Override
    public void delete(Statuses statuses) {
        logger.debug(statuses.toString());
        StatusesDao statusesDao = new StatusesDaoImpl();
        statusesDao.delete(statuses);
    }

    @Override
    public Statuses getById(int id) {
        logger.debug(id);
        StatusesDao statusesDao = new StatusesDaoImpl();
        return statusesDao.getById(id);
    }
}
