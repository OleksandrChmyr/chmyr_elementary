package homework17.dao;

import homework17.entities.Statuses;
import homework17.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StatusesDaoImpl implements StatusesDao {
    Logger logger = Logger.getLogger(StatusesDaoImpl.class);
    @Override
    public void save(Statuses statuses) {
        logger.debug(statuses.toString());
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            session.save(statuses);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public void update(Statuses statuses) {
        logger.debug(statuses.toString());
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            session.update(statuses);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }


    @Override
    public void delete(Statuses statuses) {
        logger.debug(statuses.toString());
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            session.delete(statuses);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public Statuses getById(int id) {
        logger.debug(id);
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        return session.byId(Statuses.class).getReference(id);
    }
}
