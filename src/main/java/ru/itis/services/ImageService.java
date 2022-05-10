package ru.itis.services;

import org.springframework.web.multipart.MultipartFile;
import ru.itis.models.Image;

import javax.servlet.http.HttpServletResponse;

public interface ImageService {
    String upload(MultipartFile multipart);
    void addFileToResponse(String uuid_name, HttpServletResponse response);
}
