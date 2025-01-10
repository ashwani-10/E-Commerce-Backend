package com.shopping.shoppingbackend.repository;

import com.shopping.shoppingbackend.Model.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserOrderRepo extends JpaRepository<UserOrder, UUID> {
}
