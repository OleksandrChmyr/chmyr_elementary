package homework14.dao;

import homework14.entities.Statuses;
import homework14.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StatusesDaoImpl implements StatusesDao{
    @Override
    public void save(Statuses statuses) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(statuses);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Statuses statuses) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.update(statuses);
        transaction.commit();
        session.close();
    }


    @Override
    public void delete(Statuses statuses) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(statuses);
        transaction.commit();
        session.close();
    }

    @Override
    public Statuses getById(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        return session.byId(Statuses.class).getReference(id);
    }
}
