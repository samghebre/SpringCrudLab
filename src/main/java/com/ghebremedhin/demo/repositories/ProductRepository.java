package com.ghebremedhin.demo.repositories;

import com.ghebremedhin.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
