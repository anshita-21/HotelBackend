package com.AgilePeople.project.repository;

import com.AgilePeople.project.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}