package ru.itis.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.models.Comment;

import java.util.List;
import java.util.stream.Collectors;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentDto {
    private Long id;

    private Long userId;

    private Long recipeId;

    private String comment;

    public static CommentDto from(Comment comment){
        return CommentDto.builder()
                .id(comment.getId())
                .userId(comment.getUser().getId())
                .recipeId(comment.getRecipe().getId())
                .comment(comment.getComment())
                .build();
    }

    public static List<CommentDto> from(List<Comment> comments){
        return comments.stream().map(CommentDto::from).collect(Collectors.toList());
    }
}
