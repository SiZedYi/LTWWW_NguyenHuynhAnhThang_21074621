package com.fashion.leon.ltwww_java_03112025_tuan07_nguyenhuynhanhthang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class SpringPureJdbAnnotationConfigApplication {

    @SuppressWarnings("resource")
    public static void main(String[] args) throws SQLException {
        SpringApplication.run(SpringPureJdbAnnotationConfigApplication.class, args);
        ApplicationContext context = SpringApplication.run(SpringPureJdbAnnotationConfigApplication.class, args);
        DataSource dataSource = (DataSource) context.getBean("dataSource");
        System.out.println("DataSource: " + dataSource.getConnection());
    }
}
