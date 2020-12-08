package homework14.services;

import homework14.dao.AccountDao;
import homework14.dao.AccountDaoImpl;
import homework14.entities.Accounts;

public class AccountServiceImpl implements AccountService{
    @Override
    public void save(Accounts accounts) {
        AccountDao accountDao = new AccountDaoImpl();
        accountDao.save(accounts);
    }

    @Override
    public void update(Accounts accounts) {
        AccountDao accountDao = new AccountDaoImpl();
        accountDao.update(accounts);
    }

    @Override
    public void delete(Accounts accounts) {
        AccountDao accountDao = new AccountDaoImpl();
        accountDao.delete(accounts);
    }

    @Override
    public Accounts getById(int id) {
        AccountDao accountDao = new AccountDaoImpl();
        return accountDao.getById(id);
    }
}
