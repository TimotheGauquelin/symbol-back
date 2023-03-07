package com.example.trial.controler;

import com.example.trial.model.ApologyTag;
import com.example.trial.service.ApologyTagService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = {"http://${FRONT_URL}"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
public class ApologyTagController {

    private final ApologyTagService apologyTagService;

    /**
     * {@Code: GET /apology-tags} Method which lists all apology tags.
     */
    @GetMapping("/public/apology-tags")
    public ResponseEntity<List<ApologyTag>> getAllApologyTags() {
        log.debug("Request to get all apology tags");

        List<ApologyTag> apologyTags = apologyTagService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(apologyTags);
    }

}
