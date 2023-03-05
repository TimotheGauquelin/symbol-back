package com.example.trial.service.serviceImpl;

import com.example.trial.controler.error.exception.EntityDontExistException;
import com.example.trial.model.Apology;
import com.example.trial.repository.ApologyRepository;
import com.example.trial.service.ApologyService;
import com.example.trial.service.dto.ApologyDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;

@Service
@Transactional
@RequiredArgsConstructor
public class ApologyServiceImpl implements ApologyService {

    //ModelMapper allows to map datas between different structured objects in ModelMapper
    private final ModelMapper modelMapper;

    private final ApologyRepository apologyRepository;
    @Override
    @Transactional(readOnly = true)
    public List<Apology> findAll() {
        return apologyRepository.findAll();
    }

    @Override
    public Optional<Apology> findByHttpCode(Long httpCode) {
        Optional<Apology> apology = apologyRepository.findByHttpCode(httpCode);
        if(apology.isPresent()) {
            return Optional.of(apology.get());
        }
        throw new EntityDontExistException("Apology");
    }

    @Override
    public void save(ApologyDTO apologyDTO) {

        Apology apology = modelMapper.map(apologyDTO, Apology.class);
        apologyRepository.save(apology);

    }

    @Override
    public boolean checkIfApologyMessageAlreadyExists(String message) {
        return apologyRepository.existsApologyByMessageIgnoreCase(message);
    }
}
