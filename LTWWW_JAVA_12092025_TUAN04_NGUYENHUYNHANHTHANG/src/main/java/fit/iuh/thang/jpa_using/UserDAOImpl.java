package fit.iuh.thang.jpa_using;

import jakarta.persistence.EntityManager;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private final EntityManager entityManager;

    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> findAll() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }
}