package ru.itis.services;

import org.springframework.web.multipart.MultipartFile;
import ru.itis.dto.UserDto;

public interface UserService {


    void signUp(UserDto userDto);
}
