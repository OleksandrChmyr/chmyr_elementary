package homework14.services;

import homework14.entities.Accounts;


public interface AccountService {

    void save (Accounts accounts);
    void update (Accounts accounts);
    void delete (Accounts accounts);
    Accounts getById(int id);
}
