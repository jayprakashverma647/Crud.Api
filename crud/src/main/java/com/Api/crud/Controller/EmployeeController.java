package com.Api.crud.Controller;

import com.Api.crud.Entity.Employee;
import com.Api.crud.Service.EmployeeService;
import org.hibernate.EntityMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller

public class EmployeeController {
    @Autowired
    private EmployeeService service;
    @PostMapping("/employee")
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee){
        Employee save = service.saveEmployee(employee);
        return  new ResponseEntity<>(save,HttpStatus.CREATED);
    }
    @GetMapping("/employee/{eid}")
    public ResponseEntity<Employee> getEmployeeById(
            @PathVariable int eid){
        Employee response = service.getEmployee(eid);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee>listAll= service.getAllEmployee();
        return new ResponseEntity<>(listAll,HttpStatus.OK);
    }

    @PutMapping("/employee/{eid}")
    public ResponseEntity<Employee> updateEmployeeById(@PathVariable int eid ,@RequestBody Employee employee){
    Employee updateResponse = service.updateEmployee(eid, employee);
    return new ResponseEntity<>(updateResponse,HttpStatus.ACCEPTED);
}

@DeleteMapping("/employee/{eid}")
    public ResponseEntity<Employee> deleteEmployeeById(@PathVariable int eid){
    Employee deleteEmployee = service.DeleteEmployee(eid);
    return new ResponseEntity<>(deleteEmployee,HttpStatus.GONE);
}



}
