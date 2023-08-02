package com.cm.companymanagement.repositories;

import com.cm.companymanagement.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Spring Data jPA - Query Creation from Method Names

    List<Employee> findByFirstName(String firstName);
}
