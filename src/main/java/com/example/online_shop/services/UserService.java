package com.example.online_shop.services;

import com.example.online_shop.dto.LoginDTO;
import com.example.online_shop.entities.Roles;
import com.example.online_shop.entities.Users;
import com.example.online_shop.response.LoginMessage;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    Users getUserByUsername(String username);
    List<Users> getAllUsers();
    Users createUser(Users user);
    Users saveUser(Users user);
    Users getUser(Long id);
    void deleteUser(Long id);
    LoginMessage loginUser(LoginDTO loginDTO);
    List<Roles> getAllRoles();
    Roles getRole(Long id);
}
