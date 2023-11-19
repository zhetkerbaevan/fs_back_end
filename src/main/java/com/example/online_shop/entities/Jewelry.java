package com.example.online_shop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "jewelry")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Jewelry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="price")
    private int price;
    @Column(name="description")
    private String description;
    @Column(name="photo")
    private String photo;
    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;
}
