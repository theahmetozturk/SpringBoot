package com.cm.companymanagement.implementation;

import com.cm.companymanagement.entities.Employee;
import com.cm.companymanagement.repositories.EmployeeRepository;
import com.cm.companymanagement.sevices.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public void save(Employee employee) throws Exception {
        try {
            employeeRepository.save(employee);
        } catch (Exception ex) {
            throw new Exception("Exception Message" + ex.getMessage());
        }
    }

    @Override
    public List<Employee> findAll() throws Exception {
        try {
            return employeeRepository.findAll();
        } catch (Exception ex) {
            throw new Exception("Exception Message:" + ex.getMessage());
        }
    }

    @Override
    public Employee findById(Long employeeId) throws Exception {
        try {
            Employee response;
            Optional<Employee> employee=employeeRepository.findById(employeeId);
            if (employee.isPresent()){
                response = employee.get();
                return response;
            }else {
                throw new RuntimeException("Employee not found for the id"+ employeeId);
            }
        }catch (Exception ex){
            throw new Exception("Exception message"+ex.getMessage());
        }
    }

    @Override
    public void delete(Long employeeId) throws Exception {
        try{
            Employee employee = findById(employeeId);
            if (employee!=null) {
                employeeRepository.delete(employee);
            }else {
                throw new RuntimeException("Employee not found for the id"+ employeeId);
            }
        }catch (Exception ex){
            throw new Exception("Exception Message"+ex.getMessage());
        }
    }

    public List<Employee> findByFirstName(String firstName) throws Exception {
        try{
            List<Employee> employeeList = employeeRepository.findByFirstName(firstName);
            if (employeeList != null){
                return employeeList;
            }else {
                throw new RuntimeException("Employee not found for the firstName"+ firstName);
            }
        }catch (Exception ex){
            throw new Exception("Exception Message:"+ex.getMessage());
        }

    }

}
