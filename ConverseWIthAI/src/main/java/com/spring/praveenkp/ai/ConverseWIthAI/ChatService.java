package com.spring.praveenkp.ai.ConverseWIthAI;

//import dev.langchain4j.model.huggingface.HuggingFaceChatModel;
//import dev.langchain4j.model.output.Response;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.mistralai.MistralAiChatModel;
//import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.mistralai.MistralAiChatOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChatService {

//    private HuggingFaceChatModel chatModel;
//    private final OpenAiChatModel chatModel;

    private final MistralAiChatModel chatModel;

//    @Autowired
//    private final HuggingFaceConfig huggingFaceConfig;


    @Autowired
    public ChatService(MistralAiChatModel chatModel) {
        this.chatModel = chatModel;
    }


//    @Autowired
//    public ChatService(HuggingFaceChatModel chatModel, HuggingFaceConfig huggingFaceConfig) {
//        this.chatModel = chatModel;
//        this.huggingFaceConfig = huggingFaceConfig;
//    }

//    public String chatWithAI(String prompt){
//        chatModel = huggingFaceConfig.huggingFaceChatModel();
//        List<String> query = new ArrayList<>();
//        query.add(prompt);
//        String response =  chatModel.generate(query.get(0));
//        System.out.println("Got it as reply:" + response);
//        return response;

//    }

    public String chatWithAI(String prompt){
        return chatModel.call(prompt);
    }

    public String chatWithAIOptions(String prompt){
         ChatResponse response = chatModel.call(
                new Prompt(
                        prompt,
                        MistralAiChatOptions.builder()
                                .withModel("open-mistral-7b")
                                .withMaxTokens(10)
                                .withTemperature(0.9F)
                                .build()
                        )
                );

         String rawResponse = response.getResult().getOutput().getContent();

         //Filter the result till first full-stop(".")
         int periodIndex = rawResponse.indexOf('.');
         return (periodIndex != -1) ? rawResponse.substring(0, periodIndex + 1) : rawResponse;

    }

}
