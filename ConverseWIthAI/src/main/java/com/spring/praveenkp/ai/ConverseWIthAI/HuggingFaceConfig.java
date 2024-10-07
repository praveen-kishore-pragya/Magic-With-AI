package com.spring.praveenkp.ai.ConverseWIthAI;

//import dev.langchain4j.model.huggingface.HuggingFaceChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Configuration
public class HuggingFaceConfig{

//    @Bean
//    public HuggingFaceChatModel huggingFaceChatModel() {
//        try {
//            return HuggingFaceChatModel.builder()
//                    .accessToken("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")
//                    .modelId("google/flan-t5-base")
//                    .timeout(Duration.ofSeconds(20))
//                    .build();
//        } catch (Exception e) {
//            // Log the error or throw a runtime exception
//            System.err.println("Error creating HuggingFaceChatModel: " + e.getMessage());
//            throw e; // rethrow to maintain Spring's exception handling
//        }
//    }
}
