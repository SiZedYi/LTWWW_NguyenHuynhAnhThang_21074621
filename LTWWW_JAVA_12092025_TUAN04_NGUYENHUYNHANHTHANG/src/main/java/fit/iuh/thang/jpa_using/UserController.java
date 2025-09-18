package fit.iuh.thang.jpa_using;

import java.util.List;
import jakarta.persistence.*;
public class UserController {
    public List<User> getAllUsers() {
        try (EntityManager entityManager = EntityManagerFactoryUtil.getEntityManager()) {
            UserDAO userDao = new UserDAOImpl(entityManager);
            List<User> listUser = userDao.findAll();
            return listUser;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return List.of();
    }
}
