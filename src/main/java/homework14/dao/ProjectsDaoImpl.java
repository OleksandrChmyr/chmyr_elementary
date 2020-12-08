package homework14.dao;

import homework14.entities.Projects;
import homework14.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ProjectsDaoImpl implements ProjectsDao{
    @Override
    public void save(Projects projects) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(projects);
        transaction.commit();
        session.close();

    }

    @Override
    public void update(Projects projects) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.update(projects);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Projects projects) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(projects);
        transaction.commit();
        session.close();
    }

    @Override
    public Projects getById(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        return session.byId(Projects.class).getReference(id);
    }
}
