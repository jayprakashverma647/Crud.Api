package com.Api.crud.Entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


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
    @Column(unique = true)
    private String email;
    private long mobile;
    private int age;

}
