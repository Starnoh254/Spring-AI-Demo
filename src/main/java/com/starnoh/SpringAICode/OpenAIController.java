package com.starnoh.SpringAICode;


import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpenAIController {


    private OpenAiChatModel chatModel;

    public OpenAIController(OpenAiChatModel chatModel) {

        this.chatModel = chatModel;
    }

    @RequestMapping("/api/{message}")
    public String getAnswer(@PathVariable String message) {

        return chatModel.call(message);
    }


}
