package com.example.trial.controller;

import com.example.trial.Application;
import com.example.trial.model.Apology;
import com.example.trial.repository.ApologyRepository;
import com.example.trial.utils.ApologyTestUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest(classes = {Application.class})
public class ApologyControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ApologyRepository apologyRepository;
    @Autowired
    private EntityManager em;
    @Autowired
    private ObjectMapper objectMapper;

    private Apology apology;


    //Create Apology with Success
    @Test
    @Transactional
    void testCreateApologyWithSuccess() throws Exception {
        int sizeOfListBeforeInitialization = apologyRepository.findAll().size();

        apology = ApologyTestUtils.apologyTest("sA4zjfdr8b", "Inexcusable");
        mockMvc.perform(post("/api/public/apologies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(apology)))
                .andExpect(status().isCreated());

        List<Apology> apologyModelList = apologyRepository.findAll();
        assertThat(apologyModelList).hasSize(sizeOfListBeforeInitialization +1);
    }

    //Create Apology but failed because name already exists
    @Test
    @Transactional
    void testCreateApologyButNameAlreadyExists() throws Exception {
        int sizeOfListBeforeInitialization = apologyRepository.findAll().size();

        apology = ApologyTestUtils.apologyTest("test", "Inexcusable");
        mockMvc.perform(post("/api/private/apologies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(apology)))
                .andExpect(status().is4xxClientError());

        List<Apology> archetypeModelList = apologyRepository.findAll();
        assertThat(archetypeModelList).hasSize(sizeOfListBeforeInitialization);
    }

}
