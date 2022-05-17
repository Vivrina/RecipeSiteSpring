package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.dto.RateDto;
import ru.itis.models.Comment;
import ru.itis.models.Rate;
import ru.itis.models.Recipe;
import ru.itis.models.User;
import ru.itis.repositories.RateRepository;
import ru.itis.repositories.RecipeRepository;
import ru.itis.repositories.UserRepository;

@Service
public class RateServiceImpl implements RateService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private RateRepository rateRepository;


    @Override
    public Rate addRate(RateDto rateDto) {
        User user = userRepository.getById(rateDto.getUserId());
        Recipe recipe = recipeRepository.getById(rateDto.getRecipeId());
        Rate rate = Rate.builder()
                .user(user)
                .recipe(recipe)
                .value(rateDto.getValue())
                .build();
        return rateRepository.save(rate);
    }
}
