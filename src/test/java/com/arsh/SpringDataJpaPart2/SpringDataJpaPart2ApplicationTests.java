package com.arsh.SpringDataJpaPart2;

import com.arsh.SpringDataJpaPart2.Question3.entities.Check;
import com.arsh.SpringDataJpaPart2.Question3.entities.CreditCard;
import com.arsh.SpringDataJpaPart2.Question3.repo.PaymentRepository;
import com.arsh.SpringDataJpaPart2.Question4.entities.Employee1;
import com.arsh.SpringDataJpaPart2.Question4.entities.SalaryDetails;
import com.arsh.SpringDataJpaPart2.Question4.repo.EmployeeRepository1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringDataJpaPart2ApplicationTests {

	@Autowired
	PaymentRepository paymentRepository;

	@Autowired
	EmployeeRepository1 employeeRepository;
	@Test
	void contextLoads() {
	}

	@Test
	public void testCreatePayment1(){
		CreditCard cc = new CreditCard();
		cc.setId(123);
		cc.setAmount(1000d);
		cc.setCardNumber("1238984028402");
		paymentRepository.save(cc);
	}


	@Test
	public void testCreatePayment2(){
		Check ch = new Check();
		ch.setId(124);
		ch.setAmount(1500d);
		ch.setCheckNumber("1238984028402");
		paymentRepository.save(ch);
	}

	@Test
	public void testEmployeeComponentMapping(){

		Employee1 employee = new Employee1();
		employee.setFirstName("Arsh");
		employee.setLastName("Nadeem");
		employee.setAge(23);

		SalaryDetails salaryDetails = new SalaryDetails();
		salaryDetails.setBasicSalary(50000);
		salaryDetails.setBonusSalary(5000);
		salaryDetails.setTaxAmount(2000);
		salaryDetails.setSpecialAllowanceSalary(3000);

		employee.setSalaryDetails(salaryDetails);
		employeeRepository.save(employee);
		System.out.println("Employee saved successfully");
	}


}
