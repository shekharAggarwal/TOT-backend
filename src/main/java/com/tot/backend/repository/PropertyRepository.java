package com.tot.backend.repository;

import com.tot.backend.model.Property;
import com.tot.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Long> {
}
