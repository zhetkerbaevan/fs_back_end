package com.example.online_shop.repositories;

import com.example.online_shop.entities.Jewelry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface JewelryRepo extends JpaRepository<Jewelry, Long> {
}
