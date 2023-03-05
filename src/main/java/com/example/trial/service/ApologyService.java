package com.example.trial.service;

import com.example.trial.model.Apology;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ApologyService {
    List<Apology> findAll();
}
