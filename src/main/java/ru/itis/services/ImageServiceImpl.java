package ru.itis.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.exception.ImageException;
import ru.itis.exception.RecipeException;
import ru.itis.models.Image;
import ru.itis.models.Recipe;
import ru.itis.repositories.ImageRepository;
import ru.itis.repositories.RecipeRepository;
import ru.itis.repositories.UserRepository;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;
import java.util.function.Supplier;


@RequiredArgsConstructor
@Service
public class ImageServiceImpl implements ImageService{

    private final ImageRepository imageRepository;
    private final UserRepository userRepository;
    private final RecipeRepository recipeRepository;

    @Transactional
    @Override
    public void upload(MultipartFile multipartFile, Image.Type type, Long id) {
        switch (type){
            case USER:{

            }
            case RECIPE:{
                Recipe recipe = recipeRepository.findById(id).orElseThrow((Supplier<RuntimeException>) ()
                        -> new RecipeException("Announcement with id: " + id + " not found"));
                Image image = loadImage(multipartFile);
                recipe.setFileName(image.getUuidName());
                recipeRepository.save(recipe);
                break;
            }
        }
    }

    Image loadImage(MultipartFile multipartFile) {
        try{
            //String extension = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));
            Image image = Image.builder()
                    .size(multipartFile.getSize())
                    .uuidName(UUID.randomUUID().toString())
                    .build();
            Files.copy(multipartFile.getInputStream(), Paths.get(image.getUuidName()));
            return imageRepository.save(image);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public void getImage(String uuidName, HttpServletResponse response) {
        Image image = imageRepository.findByUuidName(uuidName).orElseThrow((Supplier<RuntimeException>) ()
                -> new ImageException("Image with filename: " + uuidName + " not found"));
        response.setContentLength(image.getSize().intValue());
        try {
            Files.copy(Paths.get(image.getUuidName()),
                    response.getOutputStream());
            response.flushBuffer();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
