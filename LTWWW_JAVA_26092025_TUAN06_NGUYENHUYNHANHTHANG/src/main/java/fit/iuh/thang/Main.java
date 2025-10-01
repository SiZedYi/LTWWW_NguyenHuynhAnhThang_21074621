package fit.iuh.thang;

import fit.iuh.thang.annotation.Group;
import fit.iuh.thang.annotation.User;
import fit.iuh.thang.annotation.UserService;
import fit.iuh.thang.xmlbased.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    private static ApplicationContext context;
    public static void main(String[] args) {

        // XML configure
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student1 = (Student) context.getBean("student1", Student.class);
        System.out.println(student1);

        // Annotation configure
        ApplicationContext applicationContext = (ApplicationContext) context.getBean(UserService.class);
        User user = applicationContext.getBean(User.class);
        System.out.println(user);

        Group group = applicationContext.getBean(Group.class);
        System.out.println(group);
    }
}
