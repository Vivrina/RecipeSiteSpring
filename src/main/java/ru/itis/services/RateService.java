package ru.itis.services;

import ru.itis.dto.CommentDto;
import ru.itis.dto.RateDto;
import ru.itis.models.Comment;
import ru.itis.models.Rate;

public interface RateService {
    Rate addRate(RateDto rateDto);
}
