package com.arsh.RestfullWebServicesPart1.Question2345789.Entity;
//2.Create an Employee Bean(id, name, age) and service to  perform different operations related to employee.


import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class Employee {
    @Nonnull
    private Integer id;
    @Size(min = 2,message = "Size should be least 2 characters")
    private String name;
    @Positive(message = "Age must be positive")
    private Integer age;

    public Employee(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
