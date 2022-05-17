package ru.itis.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.models.Rate;
import ru.itis.models.Recipe;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RateDto {
    private Long id;

    private Long userId;

    private Long recipeId;

    private Integer value;

    public static RateDto from(Rate rate){
        return RateDto.builder()
                .id(rate.getId())
                .userId(rate.getUser().getId())
                .recipeId(rate.getRecipe().getId())
                .value(rate.getValue())
                .build();
    }
    public static List<RateDto> from(List<Rate> rates){
        return rates.stream().map(RateDto::from).collect(Collectors.toList());
    }
}
