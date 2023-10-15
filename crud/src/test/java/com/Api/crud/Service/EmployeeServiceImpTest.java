package com.Api.crud.Service;

import com.Api.crud.Entity.Employee;
import com.Api.crud.Exception.EmployeeNotFoundException;
import com.Api.crud.Repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {EmployeeServiceImp.class})
@ExtendWith(SpringExtension.class)
class EmployeeServiceImpTest {

    @MockBean
    private EmployeeRepository repository;

    @Autowired
    EmployeeService service;

    Employee employee;

    @BeforeEach
    void init(){
       employee= getEmployeeObj();
    }


    @Test
    void saveEmployee() {
        employee.setDateOfBirth(LocalDate.now());
        when(repository.save(any())).thenReturn(employee);
        Employee employee1 = service.saveEmployee(employee);
        assertNotNull(employee1);
    }


    @Test
    void getEmployee() {
        when(repository.findById(anyInt())).thenReturn(Optional.of(employee));
        assertSame(employee,service.getEmployee(anyInt()));
    }
    @Test
    void getEmployee_failed() {
        when(repository.findById(anyInt())).thenThrow(new EmployeeNotFoundException("abc"));
        assertThrows(EmployeeNotFoundException.class,()->service.getEmployee(7));
    }

    @Test
    void getAllEmployee() {
        when(repository.findAll()).thenReturn(Arrays.asList(employee));
        List<Employee> allEmployee = service.getAllEmployee();
        assertNotNull(allEmployee);
    }

    @Test
    void updateEmployee() {
    when(repository.findById(anyInt())).thenReturn(Optional.of(employee));
    when(repository.save(any())).thenReturn(employee);
    assertSame(employee,service.updateEmployee(anyInt(),employee));

    }

    @Test
    void deleteEmployee() {
        when(repository.findById(anyInt())).thenReturn(Optional.of(employee));
        assertSame(employee,service.DeleteEmployee(anyInt()));

    }

    private Employee getEmployeeObj(){
        Employee employee =new Employee();
        employee.setEid(1);
        employee.setFirstName("abc");
        employee.setLastName("xyz");
        employee.setEmail("ac@gmail.com");
        employee.setMobile(86382);
        return employee;
    }
}