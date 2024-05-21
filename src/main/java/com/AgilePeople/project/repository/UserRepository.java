package com.AgilePeople.project.repository;

import com.AgilePeople.project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}