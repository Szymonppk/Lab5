package org.example;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class HibernateSetUp {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure().buildSessionFactory();
        } catch (Exception e) {
            System.err.println("Hibernate SessionFactory creation failed");
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSession() {
        return sessionFactory;
    }

    public static void shutdownSession() {
        getSession().close();
    }
}
