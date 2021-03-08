package com.example.demo.model;

import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class RunAtStart {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public RunAtStart(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        super();
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    @PostConstruct
    public void runAtStart(){

        Set<Employee> employeesToSave = new HashSet<>();
        Employee employee = new Employee();
        employee.setFirstName("Tomasz");
        employee.setLastName("Twardowski");
        employee.setSalary(new BigDecimal("5000.00"));
        employeesToSave.add(employee);
        employeesToSave.add(new Employee("Janek", "Pakuła", new BigDecimal(14000)));
        employeesToSave.add(new Employee("Monika", "Niedzielska", new BigDecimal(3500)));
        employeesToSave.add(new Employee("Cezary", "Wiśniewski", new BigDecimal(2000)));
        employeesToSave.add(new Employee("Janina", "Kowalska", new BigDecimal(2000)));

//        employeeRepository.saveAll(employeesToSave);

        Employee byFirstNameAndLastName = employeeRepository.findByFirstNameAndLastName("Monika", "Niedzielska");
        if (byFirstNameAndLastName != null) {
            System.out.println(byFirstNameAndLastName);
            byFirstNameAndLastName.setSalary(new BigDecimal(4000));
            employeeRepository.save(byFirstNameAndLastName);
        }
        Department HR = new Department("HR",employeesToSave);
//        departmentRepository.save(HR);
//        Department searchedOne = departmentRepository.findDepartmentByName("HR");
//        Department toBeDeleted = departmentRepository.findDepartmentByName("HR");
//        departmentRepository.delete(toBeDeleted);

        System.out.println("*******************************");
        List<Employee> employees = employeeRepository.findAll();
        System.out.println(employees);

        System.out.println(employeeRepository.findSurnameStartingWithK());



    }

}
