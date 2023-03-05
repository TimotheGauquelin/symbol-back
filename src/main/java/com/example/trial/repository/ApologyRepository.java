package com.example.trial.repository;

import com.example.trial.model.Apology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApologyRepository extends JpaRepository<Apology, Long> {
    @Query(value = "SELECT * " +
            "FROM apology ", nativeQuery = true)
    List<Apology> findAllApologies();
}
