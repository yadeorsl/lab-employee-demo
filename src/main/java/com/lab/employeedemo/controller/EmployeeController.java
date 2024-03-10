package com.lab.employeedemo.controller;

import com.lab.employeedemo.model.Employee;
import com.lab.employeedemo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customers")
public class EmployeeController {
  private final EmployeeService employeeService;
   @PutMapping
  public Employee addEmployee(@RequestBody Employee employee){
     return employeeService.saveEmployee(employee);
   }
}
