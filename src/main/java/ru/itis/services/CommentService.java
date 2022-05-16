package ru.itis.services;

import ru.itis.dto.CommentDto;
import ru.itis.dto.RecipeDto;
import ru.itis.models.Comment;
import ru.itis.models.Recipe;

import java.util.List;

public interface CommentService {
    Comment addComment(CommentDto commentDto);
    List<Comment> findByRecipeId(Long id);


}
