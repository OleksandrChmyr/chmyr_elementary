package homework17.dao;

import homework17.entities.Projects;
import homework17.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ProjectsDaoImpl implements ProjectsDao {
    Logger logger = Logger.getLogger(ProjectsDaoImpl.class);
    @Override
    public void save(Projects projects) {
        logger.debug(projects.toString());
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {

            Transaction transaction = session.beginTransaction();

            session.save(projects);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            logger.error(e.getMessage());

        }

    }

    @Override
    public void update(Projects projects) {
        logger.debug(projects.toString());
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            session.update(projects);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public void delete(Projects projects) {
        logger.debug(projects.toString());
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            session.delete(projects);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public Projects getById(int id) {
        logger.debug(id);
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        return session.byId(Projects.class).getReference(id);
    }
}
