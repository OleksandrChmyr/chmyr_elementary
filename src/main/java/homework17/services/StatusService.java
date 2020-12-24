package homework17.services;

import homework17.entities.Statuses;

public interface StatusService {
    void save (Statuses statuses);
    void update (Statuses statuses);
    void delete (Statuses statuses);
    Statuses getById(int id);
}
