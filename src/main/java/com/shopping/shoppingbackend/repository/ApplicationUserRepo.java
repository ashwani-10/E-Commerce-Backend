package com.shopping.shoppingbackend.repository;

import com.shopping.shoppingbackend.Model.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ApplicationUserRepo extends JpaRepository<ApplicationUser, UUID> {

    public ApplicationUser findByEmail(String email);
}
