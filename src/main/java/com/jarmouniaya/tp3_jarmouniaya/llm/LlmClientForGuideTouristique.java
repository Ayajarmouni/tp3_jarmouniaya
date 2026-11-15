package com.jarmouniaya.tp3_jarmouniaya.llm;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.chat.request.ResponseFormat;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.service.AiServices;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LlmClientForGuideTouristique {

    private GuideTouristique guideTouristique;

    @PostConstruct
    public void init() {
        String apiKey = System.getenv("GEMINI_API_KEY");   // même nom de variable qu'au TP2

        ChatModel model = GoogleAiGeminiChatModel.builder()
                .apiKey(apiKey)
                .modelName("gemini-3.8-flash")          // mets le même modèle que dans ton TP2
                .responseFormat(ResponseFormat.JSON)
                .build();

        this.guideTouristique = AiServices.create(GuideTouristique.class, model);
    }

    public String guide(String lieu) {
        return guideTouristique.guide(lieu);
    }
}