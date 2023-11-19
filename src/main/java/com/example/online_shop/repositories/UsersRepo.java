package com.example.online_shop.repositories;

import com.example.online_shop.entities.Users;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional
public interface UsersRepo extends JpaRepository<Users, Long> {
    Optional<Users> findOneByUsernameAndPassword(String username, String password);
    Users findByUsername(String username);
}
