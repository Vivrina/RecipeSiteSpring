package ru.itis.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.models.Recipe;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecipeDto {
    private Long id;

    private String name;

    private String description;

    private String fileName;

    public static RecipeDto from(Recipe recipe){
        return RecipeDto.builder()
                .id(recipe.getId())
                .name(recipe.getName())
                .description(recipe.getDescription())
                .fileName(recipe.getFileName())
                .build();
    }

    public static List<RecipeDto> from(List<Recipe> recipes){
        return recipes.stream().map(RecipeDto::from).collect(Collectors.toList());
    }
}
