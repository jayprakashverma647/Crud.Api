package com.Api.crud.Service;

import com.Api.crud.Constant.EmployeeConstant;
import com.Api.crud.Entity.Employee;
import com.Api.crud.Exception.EmployeeNotFoundException;
import com.Api.crud.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImp implements EmployeeService {

@Autowired
public EmployeeRepository repo;



    @Override
    public Employee saveEmployee( Employee employee) {
        employee.setAge(getAge(employee.getDateOfBirth()));
        return repo.save(employee);
    }

    @Override
    public Employee getEmployee(int eid) {
        Optional<Employee> byId = repo.findById(eid);
        if(byId.isPresent()){
            return byId.get();
        }
       throw new EmployeeNotFoundException("Employee Not Found by Id :- "+eid);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return repo.findAll();
    }

    @Override
    public Employee updateEmployee(int eid, Employee employee) {
        Optional<Employee> byId = repo.findById(eid);
        if (byId.isPresent()){
          employee.setEid(eid);
            return repo.save(employee);
        }
        throw new EmployeeNotFoundException("Employee Not Found by Id :- "+eid);
    }

    @Override
    public Employee DeleteEmployee(int eid) {
        Optional<Employee> byId = repo.findById(eid);
        if (byId.isPresent()) {
            repo.deleteById(eid);
            return byId.get();
        }
       throw new EmployeeNotFoundException(EmployeeConstant.EMPLOYEE_NOT_FOUND.getValue() +eid);
    }

    private static String getAge(LocalDate dob){
        Period period=Period.between(dob,LocalDate.now());
        return period.getDays()+" Days, "+period.getMonths()+" Months, "+period.getYears()+" Years";
    }

}
