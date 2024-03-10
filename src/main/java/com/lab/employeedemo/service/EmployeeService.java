package com.lab.employeedemo.service;

import com.lab.employeedemo.model.Employee;
import com.lab.employeedemo.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> allEmployee() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeByID(long id) {
        Optional<Employee> employee=employeeRepository.findById(id);
        if (employee.isPresent()){
            return employee.get();
        }else {
            log.info("There is no employee in the id you are looking for");
            return null;
        }
    }

    public void deleteEmployeeByID(long id) {
        employeeRepository.deleteById(id);
    }

    public String updateName(long id, Employee employee) {
       Optional<Employee> employeeOptional=employeeRepository.findById(id);
       if (employeeOptional.isPresent()){
           Employee oldEmployee=employeeOptional.get();
           oldEmployee.setEmployeeName(employee.getEmployeeName());
           employeeRepository.save(oldEmployee);
           return "Successful";

       }
       return null;
    }
}
