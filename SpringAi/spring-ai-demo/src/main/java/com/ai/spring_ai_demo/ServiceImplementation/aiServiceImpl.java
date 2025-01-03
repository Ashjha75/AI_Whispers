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

    private  final OllamaChatModel ollamaChatModel;

    @Autowired
    public aiServiceImpl(OllamaChatModel ollamaChatModel) {
        this.ollamaChatModel = ollamaChatModel;
    }

    @Override
    public String getResponse(chatDto chatDto) {
        System.out.println(chatDto.getToken() + " - chatDto.getToken()");

        String templates = chatDto.getToken();
        PromptTemplate promptTemplate = new PromptTemplate(templates);
        System.out.println(promptTemplate + " - promptTemplate");

        Prompt prompt = promptTemplate.create();
        System.out.println(prompt + " - prompt");

        try {
            // Log the response from Ollama
            var response = ollamaChatModel.call(prompt);
            System.out.println("Response from Ollama: " + response);

            // Check if the response is valid
            if (response != null && response.getResult() != null) {
                String outputContent = response.getResult().getOutput().getContent();
                System.out.println("Output content: " + outputContent);
                return outputContent;
            } else {
                System.out.println("No valid response from Ollama.");
                return "Error: No valid response from Ollama.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error while communicating with Ollama: " + e.getMessage();
        }
    }

}
