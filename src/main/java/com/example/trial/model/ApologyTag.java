package com.example.trial.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "apology_tag")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApologyTag {

    @NotBlank
    @Size(max = 255)
    @Id
    @Column(name="label", unique = true, nullable = false)
    private String label;

}
