package com.example.trial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.trial.model.Apology;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ApologyRepository extends JpaRepository<Apology, Long> {

    Optional<Apology> findByHttpCode(Long httpCode);

    boolean existsApologyByMessageIgnoreCase(String message);

}
