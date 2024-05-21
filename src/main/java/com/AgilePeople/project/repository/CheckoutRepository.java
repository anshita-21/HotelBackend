package com.AgilePeople.project.repository;

import com.AgilePeople.project.entity.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckoutRepository extends JpaRepository<Checkout, Long> {
}