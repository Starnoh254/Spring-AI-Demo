package com.starnoh.SpringAICode;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GeminiService {
    private final ChatClient chatClient;

    // 1. Inject the Builder instead of ChatClient directly
    public GeminiService(ChatClient.Builder chatClientBuilder) {
        // 2. Build the ChatClient instance
        this.chatClient = chatClientBuilder.build();
    }


    public String getAnswer(String question) {
        String response = chatClient
                .prompt()
                .user(question)
                .call()
                .content();
        log.info("Response from Gemini: {}", response);
        return response;
    }
}
