package com.cm.companymanagement.controllers;

import com.cm.companymanagement.entities.Employee;
import com.cm.companymanagement.sevices.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping
    public void save(@RequestBody Employee employee) throws Exception{
        employeeService.save(employee);

    }

    @GetMapping("/getAll")
    public List<Employee> getAllEmployees() throws Exception {
        return employeeService.findAll();
    }

    @PutMapping
    public void updateEmployee(@RequestBody Employee employee) throws Exception{
        employeeService.save(employee);
    }

    @DeleteMapping("/{employeeId}")
    public void deleteEmployee (@PathVariable Long employeeId) throws Exception{
        employeeService.delete(employeeId);
    }

    @GetMapping("/findById/{employeeId}")
    public Employee findById(@PathVariable Long employeeId) throws Exception {
        Employee employee = employeeService.findById(employeeId);
        return employee;
    }

    @GetMapping("/findByFirstName/{firstName}")
    public List<Employee> findByFirstName(@PathVariable String firstName) throws Exception {
        List<Employee> employeeList=employeeService.findByFirstName(firstName);
        return employeeList;
    }
}
