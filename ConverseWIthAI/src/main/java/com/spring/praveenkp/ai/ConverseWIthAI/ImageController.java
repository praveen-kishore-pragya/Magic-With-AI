package com.spring.praveenkp.ai.ConverseWIthAI;

import org.springframework.ai.image.ImageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/generate")
public class ImageController {

    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/image")
    public ResponseEntity<byte[]> generateImage(@RequestParam String imagePrompt) {
        try {
            ImageResponse imageResponse = imageService.generateImage(imagePrompt);

            // Assuming the first result is the one we want
            String base64Image = imageResponse.getResults().get(0).getOutput().getB64Json();

            // Decode the Base64 string to byte array
            byte[] imageBytes = Base64.getDecoder().decode(base64Image);

            // Set up the headers
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_PNG); // Adjust if your image isn't always PNG
            headers.setContentLength(imageBytes.length);

            // Return the image
            return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
        } catch (Exception e) {
            // Log the error and return an error response
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }





//    public List<String> generateImage(@RequestParam String imagePrompt){
//
//        ImageResponse imageResponse = imageService.generateImage(imagePrompt);
//
//        List<String> imageURLs = imageResponse.getResults().stream()
//                .map(result -> result.getOutput().getB64Json())
//                .toList();
//
//        return imageURLs;
//
//    }
}
