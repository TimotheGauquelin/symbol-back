package com.example.trial.service.dto;

import com.example.trial.model.ApologyTag;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ApologyDTO {

    private Long httpCode;

    @NotNull
    @NotBlank
    @Size(max = 255)
    @Column(name="message", nullable = false)
    private String message;

    private ApologyTag apologyTag;

}
