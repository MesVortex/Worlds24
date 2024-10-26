package org.esports.Utility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class JPAUtil {
    private static JPAUtil instance;
    private final EntityManagerFactory entityManagerFactory;

    public JPAUtil(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public static synchronized JPAUtil getInstance(EntityManagerFactory factory) {
        if (instance == null) {
            instance = new JPAUtil(factory);
        }
        return instance;
    }
}
