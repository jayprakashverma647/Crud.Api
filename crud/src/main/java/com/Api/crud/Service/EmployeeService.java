package com.Api.crud.Service;

import com.Api.crud.Entity.Employee;

import java.time.format.DateTimeParseException;
import java.util.List;

public interface EmployeeService {
    public Employee saveEmployee(Employee employee) throws DateTimeParseException;
    public Employee getEmployee(int eid);
    public List<Employee> getAllEmployee();
    public Employee updateEmployee(int eid,Employee employee);
    public Employee DeleteEmployee(int eid);

}
