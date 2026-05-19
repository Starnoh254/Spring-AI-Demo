package com.starnoh.SpringAICode;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpenAIController {


    private ChatClient chatClient;

    public OpenAIController(OpenAiChatModel chatModel) {

        this.chatClient = ChatClient.create(chatModel);
    }

    @RequestMapping("/api/{message}")
    public ResponseEntity<String> getAnswer(@PathVariable String message) {

        String response = chatClient
                .prompt(message)
                .call()
                .content();

        return ResponseEntity.ok(response);
    }


}
