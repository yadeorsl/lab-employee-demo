package com.lab.employeedemo.controller;

import com.lab.employeedemo.model.Employee;
import com.lab.employeedemo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customers")
public class EmployeeController {
  private final EmployeeService employeeService;
   @PutMapping
  public Employee addEmployee(@RequestBody Employee employee){
     return employeeService.saveEmployee(employee);
   }
   @GetMapping
    public List<Employee> allEmployee(){
       return employeeService.allEmployee();
   }
   @GetMapping("{id}")
    public Employee getEmployeeByID(@PathVariable("id") long id){
       return employeeService.getEmployeeByID(id);
   }
}
