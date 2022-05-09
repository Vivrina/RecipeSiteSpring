package ru.itis.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.models.Recipe;

import java.util.Date;
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

    private Long userId;

    private Long categoryId;

    private Date created;

    public static RecipeDto from(Recipe recipe){
        return RecipeDto.builder()
                .id(recipe.getId())
                .name(recipe.getName())
                .userId(recipe.getUser().getId())
                .categoryId(recipe.getCategory().getId())
                .description(recipe.getDescription())
                .fileName(recipe.getFileName())
                .created(recipe.getCreated())
                .build();
    }

    public static List<RecipeDto> from(List<Recipe> recipes){
        return recipes.stream().map(RecipeDto::from).collect(Collectors.toList());
    }
}
