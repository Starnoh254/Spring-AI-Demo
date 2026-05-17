package com.starnoh.SpringAICode;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpenAIController {


    private final GeminiService geminiService;

    public OpenAIController(GeminiService geminiService) {

        this.geminiService = geminiService;
    }

    @RequestMapping("/api/{message}")
    public String getAnswer(@PathVariable String message) {

        return geminiService.getAnswer(message);
    }


}
