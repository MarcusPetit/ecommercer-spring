package br.com.marcus.ecommerce.repositories;

import br.com.marcus.ecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p JOIN p.categories c WHERE p.id = :produtoId AND c.id = :categoriaId")
    List<Product> findByProductIdAndCategoryId(@Param("produtoId") Long produtoId, @Param("categoriaId") Long categoriaId);
}