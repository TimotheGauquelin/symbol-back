package com.example.trial.service;

import com.example.trial.model.Apology;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ApologyService {
    List<Apology> findAll();

    Optional<Apology> findByHttpCode(Long httpCode);
}
