package com.shopping.shoppingbackend.Model;

import com.shopping.shoppingbackend.enums.UserType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;


@Entity
@Data
public class ApplicationUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    @Column(nullable = false)
    String name;
    @Column(unique = true, nullable = false)
    String email;
    String password;
    @Column(unique = true,nullable = false)
    Long phoneNumber;
    String address;
    @Enumerated(EnumType.STRING)
    UserType userType;
}
