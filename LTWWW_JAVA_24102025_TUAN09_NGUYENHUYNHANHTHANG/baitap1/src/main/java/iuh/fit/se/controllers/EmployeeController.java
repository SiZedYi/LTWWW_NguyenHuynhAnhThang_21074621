package iuh.fit.se.controllers;

import iuh.fit.se.entities.Employee;
import iuh.fit.se.services.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
//@RequestMapping("/employees")
public class EmployeeController {

    private final static Logger logger = LoggerFactory.getLogger(EmployeeController.class.getName());
    EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Map<String, Object>> getEmployeeById(@PathVariable int id) {
        Map<String, Object> response = new LinkedHashMap<>();

        response.put("status", HttpStatus.OK.value());
        response.put("data", this.employeeService.findById(id));

        logger.info("Action: getEmployeeById");


        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/employees")
    public ResponseEntity<Map<String, Object>> save(@RequestBody Employee employee) {

        Map<String, Object> response = new LinkedHashMap<>();
        System.out.println(employee);
        response.put("status", HttpStatus.OK.value());
        response.put("data", this.employeeService.save(employee));

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
