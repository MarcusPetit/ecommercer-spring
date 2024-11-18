package br.com.marcus.ecommerce.repositories;

import br.com.marcus.ecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
  }