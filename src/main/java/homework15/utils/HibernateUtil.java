package homework15.utils;

import homework15.entities.*;
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
//        configure.addAnnotatedClass(ClientStatus.class);
        configure.addAnnotatedClass(Statuses.class);
        configure.addAnnotatedClass(Projects.class);
        StandardServiceRegistryBuilder builder =
                new StandardServiceRegistryBuilder().applySettings(configure.getProperties());
        sessionFactory = configure.buildSessionFactory(builder.build());
        return sessionFactory;
    }
}
