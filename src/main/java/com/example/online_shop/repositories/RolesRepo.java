package com.example.online_shop.repositories;

import com.example.online_shop.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface RolesRepo extends JpaRepository<Roles, Long> {
    Roles findByRole(String role);
}
