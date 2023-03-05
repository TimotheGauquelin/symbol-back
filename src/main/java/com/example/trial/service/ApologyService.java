package com.example.trial.service;

import com.example.trial.model.Apology;
import com.example.trial.service.dto.ApologyDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ApologyService {
    List<Apology> findAll();

    Optional<Apology> findByHttpCode(Long httpCode);

    void save(ApologyDTO apologyDTO);

    boolean checkIfApologyMessageAlreadyExists(String message);
}
