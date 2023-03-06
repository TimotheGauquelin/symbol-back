package com.example.trial.utils;

import com.example.trial.model.Apology;
import com.example.trial.model.ApologyTag;

import java.time.LocalDate;
import java.util.Set;

public class ApologyTestUtils {

    public static Apology apologyTest(String message, String apologyTagLabel
    ) {
        ApologyTag apologyTag = ApologyTag.builder()
                .label(apologyTagLabel)
                .build();

        Apology archetype = Apology.builder()
                .message(message)
                .apologyTag(apologyTag)
                .build();

        return archetype;
    }

}
