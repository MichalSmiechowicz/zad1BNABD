package com.example.demo.repository;

import com.example.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findEmployeeByFirstName(String name);
    Employee findByFirstNameAndLastName(String firstName, String lastName);
    Set<Employee> findBySalaryGreaterThan(BigDecimal salary);


    @Query("SELECT e FROM Employee e WHERE e.lastName LIKE 'K%'")
    List<Employee> findSurnameStartingWithK();

}
