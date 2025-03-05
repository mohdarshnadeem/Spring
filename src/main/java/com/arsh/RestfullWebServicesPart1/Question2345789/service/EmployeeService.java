package com.arsh.RestfullWebServicesPart1.Question2345789.service;

import com.arsh.RestfullWebServicesPart1.Question2345789.Entity.Employee;
import com.arsh.RestfullWebServicesPart1.Question2345789.exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeService {

    //single employee
    //create new employee
    //delete an employee
    //update an employee

    private static List<Employee> employees = new ArrayList<>();
    private static int count =6;
    static {
        employees.add(new Employee(1,"Arsh Nadeem", 23));
        employees.add(new Employee(2, "Amit Sharma", 28));
        employees.add(new Employee(3, "Priya Verma", 25));
        employees.add(new Employee(4, "Rahul Singh", 30));
        employees.add(new Employee(5, "Neha Gupta", 27));
        employees.add(new Employee(6, "Vikram Iyer", 32));
    }

    //list of employees
    public List<Employee> getAllEmployees(){
        return employees;
    }
    //employee by Id
    public Employee getEmployeeById(int id){
        return employees.stream().filter(employee->(employee.getId() == id)).findFirst().orElse(null);
    }
    //add employee
    public Employee createEmployee(Employee employee){
         employee.setId(++count);
         employees.add(employee);
         return employee;
    }
    //delete employee
    public void deleteEmployee(int id){
        employees.removeIf(employee -> employee.getId()==id);
    }
    //update employee
    public Employee updateEmployee(int id,Employee updatedEmployee){
       Employee existingEmployee = employees.stream()
               .filter(employee1 -> employee1.getId()==id)
               .findFirst()
               .orElse(null);
       if(existingEmployee == null){
           throw new EmployeeNotFoundException("No employee of this type");
       }else{
           existingEmployee.setName(updatedEmployee.getName());
           existingEmployee.setAge(updatedEmployee.getAge());
       }
       return existingEmployee;
    }
}
