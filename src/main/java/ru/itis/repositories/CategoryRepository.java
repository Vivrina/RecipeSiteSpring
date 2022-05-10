package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
