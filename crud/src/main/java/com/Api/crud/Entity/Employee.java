package com.Api.crud.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


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
    @NotNull(message = "dob cannot be empty")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateOfBirth;
    private String age;

}
