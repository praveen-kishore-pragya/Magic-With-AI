package com.spring.praveenkp.ai.ConverseWIthAI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class ChatController {

    private final ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/ask-ai")
    public String getResponse(@RequestParam String prompt){
        return chatService.chatWithAI(prompt);
    }

    @GetMapping("/ask-ai-customised")
    public String getResponseWithOptions(@RequestParam String prompt){
        return chatService.chatWithAIOptions(prompt);
    }
}
