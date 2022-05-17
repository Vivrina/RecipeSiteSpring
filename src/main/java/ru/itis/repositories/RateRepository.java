package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.models.Rate;

public interface RateRepository extends JpaRepository<Rate, Long> {
}
