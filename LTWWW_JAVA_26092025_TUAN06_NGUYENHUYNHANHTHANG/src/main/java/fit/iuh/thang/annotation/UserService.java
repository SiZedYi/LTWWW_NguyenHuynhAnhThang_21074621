package fit.iuh.thang.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserService {
    @Bean
    public Group groupService() {
        return new Group(1, "Admin");
    }
    @Bean
    public User userService() {
        return new User(1, "John Doe", "123456", groupService());
    }
}
