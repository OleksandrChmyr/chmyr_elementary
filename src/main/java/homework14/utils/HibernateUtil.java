package homework14.utils;

import homework14.entities.Accounts;
import homework14.entities.Client;
import homework14.entities.Statuses;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory != null) {
            return sessionFactory;
        }
        Configuration configure = new Configuration().configure();
        configure.addAnnotatedClass(Client.class);
        configure.addAnnotatedClass(Accounts.class);
        configure.addAnnotatedClass(Statuses.class);
        StandardServiceRegistryBuilder builder =
                new StandardServiceRegistryBuilder().applySettings(configure.getProperties());
        sessionFactory = configure.buildSessionFactory(builder.build());
        return sessionFactory;
    }
}
