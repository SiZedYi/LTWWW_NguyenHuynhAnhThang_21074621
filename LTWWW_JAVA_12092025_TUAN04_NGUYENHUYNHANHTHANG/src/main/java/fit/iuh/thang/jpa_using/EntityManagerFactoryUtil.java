package fit.iuh.thang.jpa_using;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactoryUtil {
    private static EntityManagerFactory emf;
    static {
        try {
            emf = Persistence.createEntityManagerFactory("user-management");
        } catch (Throwable e) {
            System.out.println("Initial EntityManagerFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void close() {
        if (emf != null) {
            emf.close();
        }
    }
}
