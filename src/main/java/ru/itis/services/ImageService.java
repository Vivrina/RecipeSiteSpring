package ru.itis.services;

import org.springframework.web.multipart.MultipartFile;
import ru.itis.models.Image;

import javax.servlet.http.HttpServletResponse;

public interface ImageService {
    void upload(MultipartFile multipartFile, Image.Type type, Long id);
    void getImage(String uuid_name, HttpServletResponse response);
}
