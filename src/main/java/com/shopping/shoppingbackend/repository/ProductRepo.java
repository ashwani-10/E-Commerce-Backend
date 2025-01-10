package com.shopping.shoppingbackend.repository;

import com.shopping.shoppingbackend.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepo extends JpaRepository<Product, UUID> {
    Product findByName(String name);

}
