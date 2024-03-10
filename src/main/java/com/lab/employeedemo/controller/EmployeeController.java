package com.lab.employeedemo.controller;

import com.lab.employeedemo.model.Employee;
import com.lab.employeedemo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/employee")
public class EmployeeController {
  private final EmployeeService employeeService;
   @PostMapping
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
   @PutMapping("{id}")
   public String updateName(@PathVariable("id") long id,@RequestBody Employee employee){
       return employeeService.updateName(id,employee);
   }
   @DeleteMapping("{id}")
    public void deleteEmployeeById(@PathVariable("id") long id){
       employeeService.deleteEmployeeByID(id);
   }
}
