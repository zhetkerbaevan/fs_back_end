package com.example.online_shop.services.impl;

import com.example.online_shop.dto.LoginDTO;
import com.example.online_shop.entities.Roles;
import com.example.online_shop.entities.Users;
import com.example.online_shop.repositories.RolesRepo;
import com.example.online_shop.repositories.UsersRepo;
import com.example.online_shop.response.LoginMessage;
import com.example.online_shop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UsersRepo usersRepo;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private RolesRepo rolesRepo;

    @Override
    public LoginMessage loginUser(LoginDTO loginDTO) {
        String msg = "";
        Users user = usersRepo.findByUsername(loginDTO.getUsername());
        if (user != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = user.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<Users> employee = usersRepo.findOneByUsernameAndPassword(loginDTO.getUsername(), encodedPassword);
                if (employee.isPresent()) {
                    return new LoginMessage("Login Success", true);
                } else {
                    return new LoginMessage("Login Failed", false);
                }
            } else {
                return new LoginMessage("password does not match", false);
            }
        }else {
            return new LoginMessage("Email not exits", false);
        }
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Users myUser = usersRepo.findByUsername(s);
        if(myUser != null){
            User secUser = new User(myUser.getUsername(), myUser.getPassword(), myUser.getRoles());
            return secUser;
        }
        throw new UsernameNotFoundException("User not found");
    }
    @Override
    public Users getUserByUsername(String username) {
        return usersRepo.findByUsername(username);
    }
    @Override
    public Users createUser(Users user) {
        Users checkUser = usersRepo.findByUsername(user.getUsername());
        if(checkUser == null){
            System.out.println("user is null");
            Roles role = rolesRepo.findByRole("ROLE_USER");
            if(role!=null)
            {
                ArrayList<Roles> roles = new ArrayList<>();
                roles.add(role);
                user.setRoles(roles);
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                return usersRepo.save(user);
            }
        }
        System.out.println("user is not null");
        return null;
    }
    @Override
    public Users getUser(Long id) {
        return usersRepo.findById(id).get();
    }
    @Override
    public Users saveUser(Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return usersRepo.save(user);
    }
    @Override
    public List<Users> getAllUsers() {
        return usersRepo.findAll();
    }

    @Override
    public void deleteUser(Long id) {
        usersRepo.deleteById(id);
    }
    @Override
    public List<Roles> getAllRoles() {
        return rolesRepo.findAll();
    }

    @Override
    public Roles getRole(Long id) {
        return rolesRepo.findById(id).get();
    }
}
