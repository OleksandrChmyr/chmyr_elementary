package homework14.dao;

import homework14.entities.Accounts;
import homework14.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AccountDaoImpl implements AccountDao {
    @Override
    public void save(Accounts accounts) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(accounts);
        transaction.commit();
        session.close();

    }

    @Override
    public void update(Accounts accounts) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.update(accounts);
        transaction.commit();
        session.close();

    }

    @Override
    public void delete(Accounts accounts) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(accounts);
        transaction.commit();
        session.close();

    }

    @Override
    public Accounts getById(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        return session.byId(Accounts.class).getReference(id);
    }
}
