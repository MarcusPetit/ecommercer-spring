package br.com.marcus.ecommerce.repositories;

import br.com.marcus.ecommerce.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}