package com.growskill.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.growskill.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    // Custom queries if needed
}
