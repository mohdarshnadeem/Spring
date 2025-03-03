package com.assignment.spring_boot.Question1and3.repository;

import com.assignment.spring_boot.Question1and3.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
