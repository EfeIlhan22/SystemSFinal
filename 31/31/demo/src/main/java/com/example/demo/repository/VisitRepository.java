package com.example.demo.repository;

import com.example.demo.models.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VisitRepository extends JpaRepository<Visit, Integer> {

    Optional<Visit> findById(Long id);
}
