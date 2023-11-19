package com.example.online_shop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JewelryDto {
    private String name;
    private int price;

    private String description;

    private String photo;

    private Long category_id;
}
