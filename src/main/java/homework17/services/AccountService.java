package homework17.services;

import homework17.entities.Accounts;

public interface AccountService {

    void save (Accounts accounts);
    void update (Accounts accounts);
    void delete (Accounts accounts);
    Accounts getById(int id);


}
