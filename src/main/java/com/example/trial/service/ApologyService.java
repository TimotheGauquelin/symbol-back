package com.example.trial.service;

import com.example.trial.model.Apology;
import com.example.trial.service.dto.ApologyDTO;

import java.util.List;
import java.util.Optional;

public interface ApologyService {
    List<Apology> findAll();

    Optional<Apology> findByHttpCode(Long httpCode);

    Apology save(ApologyDTO apologyDTO);

    boolean checkIfApologyMessageAlreadyExists(String message);
}
