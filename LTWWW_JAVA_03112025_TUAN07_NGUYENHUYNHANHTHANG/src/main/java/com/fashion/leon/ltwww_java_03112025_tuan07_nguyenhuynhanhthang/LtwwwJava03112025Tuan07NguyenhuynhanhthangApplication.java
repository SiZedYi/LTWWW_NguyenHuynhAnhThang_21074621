package com.fashion.leon.ltwww_java_03112025_tuan07_nguyenhuynhanhthang;

import com.fashion.leon.ltwww_java_03112025_tuan07_nguyenhuynhanhthang.dao.EmployeeDAO;
import com.fashion.leon.ltwww_java_03112025_tuan07_nguyenhuynhanhthang.model.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication(scanBasePackages = "com.fashion.leon.ltwww_java_03112025_tuan07_nguyenhuynhanhthang.dao")
public class LtwwwJava03112025Tuan07NguyenhuynhanhthangApplication {

	public static void main(String[] args) {
		SpringApplication.run(LtwwwJava03112025Tuan07NguyenhuynhanhthangApplication.class, args);
	}

    @Bean
    CommandLineRunner runner(EmployeeDAO employeeDAO, DataSource dataSource) {
        return args -> {
            Employee employee = new Employee("John Doe", "Developer", 0);
            employeeDAO.save(employee);
            System.out.println("Saved Employee: " + employee.getId() + ", " + employee.getName());
            System.out.println("DataSource: " + dataSource.getConnection());
            // You can add more code here to interact with employeeDAO if needed
        };

    }

}
