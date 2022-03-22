package com.harish.backend.employee.manager.service;

import com.harish.backend.employee.manager.exception.UserNotFoundException;
import com.harish.backend.employee.manager.model.Employee;
import com.harish.backend.employee.manager.model.repository.EmployeeRepository;
import java.util.List;
import java.util.UUID;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.saveAndFlush(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteEmployeeById(id);
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findEmployeeById(id).orElseThrow(() -> new UserNotFoundException("User by id "+id+" was not foind"));
    }
}
