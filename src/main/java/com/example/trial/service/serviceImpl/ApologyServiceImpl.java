package com.example.trial.service.serviceImpl;

import com.example.trial.model.Apology;
import com.example.trial.repository.ApologyRepository;
import com.example.trial.service.ApologyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ApologyServiceImpl implements ApologyService {

    private final ApologyRepository apologyRepository;
    @Override
    @Transactional(readOnly = true)
    public List<Apology> findAll() {
        return apologyRepository.findAllApologies();
    }
}
