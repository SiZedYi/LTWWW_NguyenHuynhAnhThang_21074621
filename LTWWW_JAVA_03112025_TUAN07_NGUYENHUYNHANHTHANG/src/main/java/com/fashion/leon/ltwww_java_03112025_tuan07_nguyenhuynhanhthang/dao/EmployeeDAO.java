package com.fashion.leon.ltwww_java_03112025_tuan07_nguyenhuynhanhthang.dao;

import com.fashion.leon.ltwww_java_03112025_tuan07_nguyenhuynhanhthang.model.Employee;

import java.util.List;

public interface EmployeeDAO {
    void update(Employee employee);
    List<Employee> getAll();
    Employee getById(int id);
    void deleteById(int id);
    void save(Employee employee);
}
