package com.ai.spring_ai_demo.Controller;


import com.ai.spring_ai_demo.DTO.chatDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/test")
public class testController {

    @PostMapping("/chat")
    public String chat( @Valid  @RequestBody  chatDto chatDto) {
        return "Hello from chat";
    }
}
