package com.AgilePeople.project.repository;

import com.AgilePeople.project.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}