package com.arsh.SpringDataJpaPart1.Questions.repo;

import com.arsh.SpringDataJpaPart1.Questions.Entities.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    List<Employee> findAll();
    Page<Employee> findAll(Pageable pageable);
    List<Employee> findByName(String name);
    List<Employee> findByNameStartingWith(String var);
    List<Employee> findByAgeBetween(int a, int b);
}
