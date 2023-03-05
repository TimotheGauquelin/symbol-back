package com.example.trial.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "apology")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApologyTag {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "apology_tag_seq")
    @SequenceGenerator(
            name="apology_tag_seq",
            sequenceName = "apology_tag_seq",
            allocationSize = 1,
            initialValue = 1000)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @NotBlank
    @Size(min = 5, max = 50)
    @Column(name="label", nullable = false, unique = true, length = 50)
    private String label;

}
