package com.example.trial.utils;

import com.example.trial.model.Apology;
import com.example.trial.model.ApologyTag;

public class ApologyTestUtils {

    public static Apology apologyTest(String message, String apologyTagLabel
    ) {
        ApologyTag apologyTag = ApologyTag.builder()
                .label(apologyTagLabel)
                .build();

        Apology apology = Apology.builder()
                .message(message)
                .apologyTag(apologyTag)
                .build();

        return apology;
    }

}
