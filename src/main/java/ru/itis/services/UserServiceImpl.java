package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.dto.UserDto;
import ru.itis.exception.UserAlreadyExistException;
import ru.itis.models.User;
import ru.itis.repositories.UserRepository;

import java.util.Date;

import static ru.itis.models.User.Role.USER;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void signUp(UserDto userDto) {
        if (!userRepository.existsByEmail(userDto.getEmail())) {
            User user = User.builder()
                    .name(userDto.getName())
                    .passwordHash(passwordEncoder.encode(userDto.getPassword()))
                    .email(userDto.getEmail())
                    .achievement(0)
                    .created(new Date())
                    .fileName(null)
                    .role(USER)
                    .build();
            userRepository.save(user);
        } else {
            throw new UserAlreadyExistException(String.format("Пользователь с email=%s уже существует", userDto.getEmail()));
        }
    }
}
