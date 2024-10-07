package com.spring.praveenkp.ai.ConverseWIthAI;

import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.stabilityai.StabilityAiImageModel;
import org.springframework.ai.stabilityai.api.StabilityAiImageOptions;
import org.springframework.stereotype.Component;

@Component
public class ImageService {

    private final StabilityAiImageModel imageModel;


    public ImageService(StabilityAiImageModel imageModel) {
        this.imageModel = imageModel;
    }

    public ImageResponse generateImage(String imagePrompt){
        ImageResponse imageResponse = imageModel.call(
                new ImagePrompt(
                        imagePrompt,
                        StabilityAiImageOptions.builder()
                                .withModel("stable-diffusion-xl-1024-v1-0")
//                                .withModel("sd3-medium")
                                .withHeight(1024)
                                .withWidth(1024)
                                .withSamples(1)
                                .build()
                )
        );

        return imageResponse;
    }
}
