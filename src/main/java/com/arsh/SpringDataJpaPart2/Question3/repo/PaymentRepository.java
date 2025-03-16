package com.arsh.SpringDataJpaPart2.Question3.repo;

import com.arsh.SpringDataJpaPart2.Question3.entities.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {

}
