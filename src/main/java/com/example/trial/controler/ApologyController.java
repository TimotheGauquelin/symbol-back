package com.example.trial.controler;

import com.example.trial.controler.error.exception.IdMustBeNullException;
import com.example.trial.model.Apology;
import com.example.trial.service.ApologyService;
import com.example.trial.service.dto.ApologyDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
public class ApologyController {

    private final ApologyService apologyService;

    /**
     * {@Code: GET /apologies} Method which lists all apologies.
     */
    @GetMapping("/public/apologies")
    public ResponseEntity<List<Apology>> getAllApologies() {
        log.debug("Request to get all apologies");

        List<Apology> apologies = apologyService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(apologies);
    }

    /**
     * {@Code: GET /apologies/{id}} Method which retrieves an apology by his http_code.
     */
    @GetMapping("/public/apologies/{httpCode}")
    public ResponseEntity<Optional<Apology>> getApologyByHttpCode(@PathVariable Long httpCode) {
        log.debug("Request to get an apology by his http_code");

        Optional<Apology> apology = apologyService.findByHttpCode(httpCode);
        return ResponseEntity.status(HttpStatus.OK).body(apology);
    }

    /**
     * {@Code: POST /apologies} Method which adds an apology.
     * @param apologyDTO needs a unique message AND an apologyTag label
     */
    @PostMapping("/public/apologies")
    public ResponseEntity<Void> addApology(@Valid @RequestBody ApologyDTO apologyDTO) {
        log.debug("Request to add an apology: {}", apologyDTO );

        if(apologyDTO.getHttpCode() != null)
            throw new IdMustBeNullException();

        apologyService.save(apologyDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
