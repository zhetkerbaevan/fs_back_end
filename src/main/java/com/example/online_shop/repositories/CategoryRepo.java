package com.example.online_shop.repositories;

import com.example.online_shop.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CategoryRepo extends JpaRepository<Category, Long> {
}
