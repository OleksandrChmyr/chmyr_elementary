package homework17.dao;

import homework17.entities.Client;
import homework17.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ClientDaoImpl implements ClientDao {
    Logger logger = Logger.getLogger(ClientDaoImpl.class);
    @Override
    public void save(Client client) {
        logger.debug(client.toString());
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(client);
        transaction.commit();
        session.close();
    }


    @Override
    public void update(Client client) {
        logger.debug(client.toString());
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.update(client);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Client client) {
        logger.debug(client.toString());
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            session.delete(client);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            logger.error(e.getMessage());

        }

    }

    @Override
    public Client getById(int id) {
        logger.debug(id);
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        return session.byId(Client.class).getReference(id);
    }

    @Override
    public Client getByPhone(long phone) {
        logger.debug(phone);
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        return session.byId(Client.class).getReference(phone);
    }
}
