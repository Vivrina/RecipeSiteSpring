package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.dto.CommentDto;
import ru.itis.models.Category;
import ru.itis.models.Comment;
import ru.itis.models.Recipe;
import ru.itis.models.User;
import ru.itis.repositories.CommentRepository;
import ru.itis.repositories.RecipeRepository;
import ru.itis.repositories.UserRepository;

import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment addComment(CommentDto commentDto) {

        User user = userRepository.getById(commentDto.getUserId());
        Recipe recipe = recipeRepository.getById(commentDto.getRecipeId());
        Comment comment = Comment.builder()
                .user(user)
                .recipe(recipe)
                .comment(commentDto.getComment())
                .build();

        return commentRepository.save(comment);
    }

    @Transactional
    @Override
    public List<Comment> findByRecipeId(Long id) {
        Recipe recipe = recipeRepository.getById(id);
        return commentRepository.findCommentByRecipe(recipe);
    }
}
