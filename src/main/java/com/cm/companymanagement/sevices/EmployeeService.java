package com.cm.companymanagement.sevices;

import com.cm.companymanagement.entities.Employee;

import java.util.List;

public interface EmployeeService {
    void save(Employee employee) throws Exception;

    List<Employee> findAll() throws Exception;

    Employee findById(Long employeeId) throws Exception;

    void delete(Long employeeId) throws Exception;

    List<Employee> findByFirstName(String firstName) throws Exception;
}
