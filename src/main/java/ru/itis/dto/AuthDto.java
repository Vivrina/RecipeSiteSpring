package ru.itis.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.models.Auth;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthDto {
    private Long id;
    private Long userId;
    private String cookieValue;

    public static AuthDto from(Auth auth) {
        return AuthDto.builder()
                .id(auth.getId())
                .userId(auth.getUser().getId())
                .cookieValue(auth.getCookieValue())
                .build();
    }

    public static List<AuthDto> from(List<Auth> auths) {
        return auths.stream().map(AuthDto::from).collect(Collectors.toList());
    }
}
