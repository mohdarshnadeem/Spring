package com.arsh.SpringDataJpaPart2.Question12.repo;

import com.arsh.SpringDataJpaPart2.Question12.entities.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    @Query("Select e.firstName, e.lastName from Employee e where e.salary > (select AVG(e.salary) from Employee e) order by e.age asc, e.salary desc")
    List<Object[]> findEmployeesWithSalaryGreaterThanAverage();

    @Modifying
    @Transactional
    @Query(value = "UPDATE employee_table e1 "
            + "JOIN (SELECT AVG(e2.emp_salary) AS avgSalary FROM employee_table e2) AS temp "
            + "ON e1.emp_salary < temp.avgSalary "
            + "SET e1.emp_salary = :newSalary",
            nativeQuery = true)
    int updateSalaryForEmployeesBelowAverage(@Param("newSalary") double newSalary);

    @Query("select min(e.salary) from Employee e")
    Double findMinSalary();

    @Modifying
    @Transactional
    @Query("delete from Employee e where e.salary =: minSalary")
    void deleteEmployeesWithMinSalary(@Param("minSalary") Double minSalary);

    @Query(value = "SELECT id, emp_first_name, emp_age FROM employee_table WHERE emp_last_name LIKE '%Singh'", nativeQuery = true)
    List<Object[]> findEmployeesWithLastNameSingh();

    @Modifying
    @Transactional
    @Query("delete from Employee e where e.age > :age")
    int deleteEmployeeOlderThan(@Param("age") int age);

}
