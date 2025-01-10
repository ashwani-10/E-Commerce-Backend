package com.shopping.shoppingbackend.repository;

import com.shopping.shoppingbackend.Model.ApplicationUser;
import com.shopping.shoppingbackend.Model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Repository
public interface CartRepo extends JpaRepository<Cart, UUID> {

}
