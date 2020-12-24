package homework17.dao;

import homework17.entities.Accounts;

public interface AccountDao {


    void save (Accounts accounts);
    void update (Accounts accounts);
    void delete (Accounts accounts);
    Accounts getById(int id);
}
