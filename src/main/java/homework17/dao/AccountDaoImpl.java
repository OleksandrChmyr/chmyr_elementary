package homework17.dao;

import homework17.entities.Accounts;
import homework17.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AccountDaoImpl implements AccountDao {
    Logger logger = Logger.getLogger(AccountDaoImpl.class);

    @Override
    public void save(Accounts accounts) {
        logger.debug(accounts.toString());
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            session.save(accounts);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            logger.error(e.getMessage());

        }

    }

    @Override
    public void update(Accounts accounts) {
        logger.debug(accounts.toString());
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            session.update(accounts);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            logger.error(e.getMessage());

        }

    }

    @Override
    public void delete(Accounts accounts) {
        logger.debug(accounts.toString());
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            session.delete(accounts);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            logger.error(e.getMessage());

        }

    }

    @Override
    public Accounts getById(int id) {
        logger.debug(id);
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        return session.byId(Accounts.class).getReference(id);
    }
}
