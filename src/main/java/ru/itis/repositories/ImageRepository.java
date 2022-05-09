package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.models.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
