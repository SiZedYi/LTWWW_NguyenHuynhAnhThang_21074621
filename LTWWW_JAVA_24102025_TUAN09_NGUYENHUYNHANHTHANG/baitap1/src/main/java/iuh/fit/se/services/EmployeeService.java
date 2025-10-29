package iuh.fit.se.services;

import iuh.fit.se.entities.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    public Employee findById(int id);
    public List<Employee> findAll();
    public Page<Employee> findAllWithPaging(Pageable pageable);
    public Employee save(Employee employee);
    public boolean delete(int id);
    public List<Employee> search(String keyword);

}
