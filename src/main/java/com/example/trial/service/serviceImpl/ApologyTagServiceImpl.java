package com.example.trial.service.serviceImpl;

import com.example.trial.model.ApologyTag;
import com.example.trial.repository.ApologyTagRepository;
import com.example.trial.service.ApologyTagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ApologyTagServiceImpl implements ApologyTagService {

    private final ApologyTagRepository apologyTagRepository;
    @Override
    public List<ApologyTag> findAll() {
        return apologyTagRepository.findAll();
    }
}
