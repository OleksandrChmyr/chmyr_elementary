package homework14.dao;

import homework14.entities.Statuses;

public interface StatusesDao {
    void save (Statuses statuses);
    void update (Statuses statuses);
    void delete (Statuses statuses);
    Statuses getById(int id);
}
