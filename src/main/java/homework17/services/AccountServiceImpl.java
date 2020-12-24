package homework17.services;

import homework17.dao.AccountDao;
import homework17.dao.AccountDaoImpl;
import homework17.entities.Accounts;
import org.apache.log4j.Logger;

public class AccountServiceImpl implements AccountService{
    Logger logger = Logger.getLogger(AccountServiceImpl.class);
    @Override
    public void save(Accounts accounts) {
        logger.debug(accounts.toString());
        AccountDao accountDao = new AccountDaoImpl();
        accountDao.save(accounts);
    }

    @Override
    public void update(Accounts accounts) {
        logger.debug(accounts.toString());
        AccountDao accountDao = new AccountDaoImpl();
        accountDao.update(accounts);
    }

    @Override
    public void delete(Accounts accounts) {
        logger.debug(accounts.toString());
        AccountDao accountDao = new AccountDaoImpl();
        accountDao.delete(accounts);
    }

    @Override
    public Accounts getById(int id) {
        logger.debug(id);
        AccountDao accountDao = new AccountDaoImpl();
        return accountDao.getById(id);
    }
}
