package homework14.services;

import homework14.entities.Statuses;

public interface StatusService {
    void save (Statuses statuses);
    void update (Statuses statuses);
    void delete (Statuses statuses);
    Statuses getById(int id);
}
