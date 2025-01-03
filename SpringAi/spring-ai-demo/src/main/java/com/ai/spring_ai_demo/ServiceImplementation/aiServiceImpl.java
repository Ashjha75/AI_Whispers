package com.ai.spring_ai_demo.ServiceImplementation;

import com.ai.spring_ai_demo.DTO.chatDto;
import com.ai.spring_ai_demo.Service.aiService;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class aiServiceImpl implements aiService {

    private final OllamaChatModel ollamaChatModel;

    @Autowired
    public aiServiceImpl(OllamaChatModel ollamaChatModel) {
        this.ollamaChatModel = ollamaChatModel;
    }

    @Override
    public String getResponse(chatDto chatDto) {
        System.out.println(chatDto.getToken() + " -   chatDto.getToken()");

        String templates = chatDto.getToken();

        PromptTemplate promptTemplate = new PromptTemplate(templates);

        System.out.println(promptTemplate + " -   promptTemplate");
        Prompt prompt = promptTemplate.create();

        return ollamaChatModel.call(prompt).getResult().getOutput().getContent();
    }
}
