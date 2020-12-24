package homework17.utils;

import homework17.entities.Accounts;
import homework17.entities.Client;
import homework17.entities.Projects;
import homework17.entities.Statuses;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    Logger logger = Logger.getLogger(HibernateUtil.class);
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        Logger logger = Logger.getLogger(HibernateUtil.class);
        if (sessionFactory != null) {
            return sessionFactory;
        }
        try {
            Configuration configure = new Configuration().configure();
            configure.addAnnotatedClass(Client.class);
            configure.addAnnotatedClass(Accounts.class);
            configure.addAnnotatedClass(Statuses.class);
            configure.addAnnotatedClass(Projects.class);
            StandardServiceRegistryBuilder builder =
                    new StandardServiceRegistryBuilder().applySettings(configure.getProperties());
            sessionFactory = configure.buildSessionFactory(builder.build());
            return sessionFactory;
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return sessionFactory;
    }
}
