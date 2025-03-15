package dev.keerthana.productservice.repository;

import dev.keerthana.productservice.models.category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<category,Integer> {
    Optional<category> findByTitle(String title);
    Optional<category> findById(int id);
}
