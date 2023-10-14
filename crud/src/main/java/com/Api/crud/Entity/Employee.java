package com.Api.crud.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue
    private int eid;
    @NotEmpty(message = "First Name Can't be Null")
    private String firstName;
    @NotEmpty(message = "Last Name Can't be Null")
    private String lastName;
    @Email(message = "Write a proper Way :- demo@gmail.com")
    private String email;
    private long mobile;
  @DateTimeFormat(pattern = "dd/MM/yyyy")
    private String dateOfBirth;
    private int age;

}
