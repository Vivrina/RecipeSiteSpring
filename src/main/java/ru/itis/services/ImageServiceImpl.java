package ru.itis.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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


@Service
public class ImageServiceImpl implements ImageService{

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @Value("${storage.path}")
    private String storagePath;

    @Transactional
    @Override
    public String upload(MultipartFile multipart) {
        try {
            String extension = multipart.getOriginalFilename().substring(multipart.getOriginalFilename().lastIndexOf("."));

            String uuidName = UUID.randomUUID().toString();


            Image image = Image.builder()
                    .type(multipart.getContentType())
                    .uuidName(uuidName)
                    .size(multipart.getSize())
                    .extension(extension)
                    .build();

            String storageFileName = uuidName + extension;
            Files.copy(multipart.getInputStream(), Paths.get(storagePath, storageFileName));

            imageRepository.save(image);
            return image.getUuidName();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public void addFileToResponse(String uuidName, HttpServletResponse response) {
        Image image = imageRepository.findByUuidName(uuidName).orElseThrow((Supplier<RuntimeException>) ()
                -> new ImageException("Image with filename: " + uuidName + " not found"));
        response.setContentLength(image.getSize().intValue());
        response.setContentType(image.getType());
        try {
            String storageFileName = image.getUuidName() + image.getExtension();
            Files.copy(Paths.get(storagePath+storageFileName),
                    response.getOutputStream());
            response.flushBuffer();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
