package com.ai.spring_ai_demo.Controller;


import com.ai.spring_ai_demo.DTO.chatDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import  com.ai.spring_ai_demo.Service.aiService;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/test")
public class testController {

    public final aiService aiService;

    @Autowired
    public testController(aiService aiService) {
        this.aiService = aiService;
    }

    @PostMapping("/chat")
    public String chat( @Valid  @RequestBody  chatDto chatDto) {
        return aiService.getResponse(chatDto);
    }
}
