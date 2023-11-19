package com.example.online_shop.controllers;

import com.example.online_shop.dto.LoginDTO;
import com.example.online_shop.entities.*;

import com.example.online_shop.response.LoginMessage;
import com.example.online_shop.services.JewelryService;
import com.example.online_shop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class APIController {

    @Autowired
    private JewelryService jewelryService;
    @Autowired
    private UserService userService;

    @GetMapping("/jewelries")
    public List<Jewelry> getAllJewelries(){
        return jewelryService.getAllJewelry();
    }

    @PostMapping("/addJewelry")
    public Jewelry addNewAnimal(@RequestBody JewelryDto jewelryDto){
        System.out.println("New Jewelry: " + jewelryDto);
        Jewelry jewelry = new Jewelry();
        Category category = jewelryService.getCategory(jewelryDto.getCategory_id());
        jewelry.setName(jewelryDto.getName());
        jewelry.setPrice(jewelryDto.getPrice());
        jewelry.setDescription(jewelryDto.getDescription());
        jewelry.setPhoto(jewelryDto.getPhoto());
        jewelry.setCategory(category);
        return jewelryService.saveJewelry(jewelry);
    }

    @DeleteMapping("/deleteJewelry/{id}")
    public String deleteJewelry(@PathVariable Long id){
        jewelryService.deleteJewelry(id);
        return "deleted";
    }

    @GetMapping("/getJewelry/{id}")
    public Jewelry getJewelry(@PathVariable Long id){
        System.out.println("ID: " + id + " res: " + jewelryService.getJewelry(id));
        return jewelryService.getJewelry(id);
    }

    @PutMapping("/updateJewelry/{id}")
    public Jewelry updateJewelry(@PathVariable Long id, @RequestBody JewelryDto jewelryDto) {

        System.out.println(jewelryDto);
        Jewelry jewelry = jewelryService.getJewelry(id);
        if(jewelryDto.getName()!=null){
            jewelry.setName(jewelryDto.getName());
        }
        if(jewelryDto.getPrice()!=0){
            jewelry.setPrice(jewelryDto.getPrice());
        }
        if(jewelryDto.getDescription() != null){
            jewelry.setDescription(jewelryDto.getDescription());
        }
        if(jewelryDto.getPhoto()!=null){
            jewelry.setPhoto(jewelryDto.getPhoto());
        }
        if(jewelryDto.getCategory_id()!=null){
            Category updatedCategory = jewelryService.getCategory(jewelryDto.getCategory_id());
            jewelry.setCategory(updatedCategory);
        }

        return jewelryService.saveJewelry(jewelry);
    }

    @GetMapping("/category")
    public List<Category> getALlCl(){
        return jewelryService.getAllCategory();
    }

    @GetMapping("/users")
    public List<Users> getAllUsers(){
        return userService.getAllUsers();
    }
    @PostMapping("addUser")
    public Users addNewUser(@RequestBody Users userFromOutside){
        System.out.println("New User: " + userFromOutside);
        Users user = new Users();
        user.setUsername(userFromOutside.getUsername());
        user.setPassword(userFromOutside.getPassword());
        user.setName(userFromOutside.getName());
        user.setSurname(userFromOutside.getSurname());
        user.setEmail(userFromOutside.getEmail());
        user.setGender(userFromOutside.getGender());
        user.setAbout_me(userFromOutside.getAbout_me());
        return userService.createUser(user);
    }

    @PutMapping("/updateUser/{id}")
    public Users updateUser(@PathVariable Long id, @RequestBody Users updatingUser) {
        System.out.println(updatingUser);
        Users user = userService.getUser(id);
        System.out.println(user);
        if(updatingUser.getName() != null){
            user.setName(updatingUser.getName());
        }
        if(updatingUser.getSurname()!= null){
            user.setSurname(updatingUser.getSurname());
        }
        if(updatingUser.getUsername()!= null){
            user.setUsername(updatingUser.getUsername());
        }
        if(updatingUser.getPassword()!= null){
            user.setPassword(updatingUser.getPassword());
        }
        if(updatingUser.getEmail()!= null){
            user.setEmail(updatingUser.getEmail());
        }
        if(updatingUser.getGender()!= 0){
            user.setGender(updatingUser.getGender());
        }
        user.setAbout_me(updatingUser.getAbout_me());
        return userService.saveUser(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return "deleted";
    }

    @GetMapping("/getUser/{id}")
    public Users getUser(@PathVariable Long id){
        System.out.println("ID: " + id + " res: " + userService.getUser(id));
        return userService.getUser(id);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        LoginMessage loginResponse = userService.loginUser(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }
}