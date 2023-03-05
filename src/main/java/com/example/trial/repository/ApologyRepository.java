package com.example.trial.repository;

import com.example.trial.model.Apology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApologyRepository extends JpaRepository<Apology, Long> {

    Optional<Apology> findByHttpCode(Long httpCode);
}
