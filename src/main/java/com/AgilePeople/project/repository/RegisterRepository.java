package com.AgilePeople.project.repository;

import com.AgilePeople.project.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepository extends JpaRepository<Register, Long> {
}