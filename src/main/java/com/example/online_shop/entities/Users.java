package com.example.online_shop.entities;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long user_id;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="name")
    private String name;
    @Column(name="surname")
    private String surname;
    @Column(name="gender")
    private int gender;
    @Column(name="email", length = 70)
    private String email;
    @Column(name="about_me")
    private String about_me;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Roles> roles;
}
