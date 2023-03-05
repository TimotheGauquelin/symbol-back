package com.example.trial.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "apology")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Apology {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "apology_seq")
    @SequenceGenerator(
            name="apology_seq",
            sequenceName = "apology_seq",
            allocationSize = 1,
            initialValue = 1000)
    @Column(name = "http_code", nullable = false)
    private Long httpCode;

    private String message;

    @ManyToOne(optional = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private ApologyTag apologyTag;

}
