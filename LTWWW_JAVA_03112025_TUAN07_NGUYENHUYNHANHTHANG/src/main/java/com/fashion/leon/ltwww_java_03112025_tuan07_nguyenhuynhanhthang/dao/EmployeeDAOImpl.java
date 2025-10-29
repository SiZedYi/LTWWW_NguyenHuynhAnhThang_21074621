package com.fashion.leon.ltwww_java_03112025_tuan07_nguyenhuynhanhthang.dao;

import com.fashion.leon.ltwww_java_03112025_tuan07_nguyenhuynhanhthang.model.Employee;
import org.springframework.context.annotation.Primary;
import javax.sql.DataSource;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.ArrayList;

public class EmployeeDAOImpl implements EmployeeDAO {
    private DataSource dataSource;
    private final ConcurrentHashMap<Integer, Employee> store = new ConcurrentHashMap<>();
    private final AtomicInteger idGen = new AtomicInteger(1);

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void deleteById(int id) {
        store.remove(id);
    }

    @Override
    public void update(Employee employee) {
        if (employee.getId() == 0) throw new IllegalArgumentException("Employee id required for update");
        store.put(employee.getId(), employee);
    }

    @Override
    public Employee getById(int id) {
        return store.get(id);
    }

    @Override
    public void save(Employee employee) {
        if (employee.getId() == 0) {
            int id = idGen.getAndIncrement();
            employee.setId(id);
        }
        store.put(employee.getId(), employee);
    }

    @Override
    public List<Employee> getAll() {
        return new ArrayList<>(store.values());
    }
}

