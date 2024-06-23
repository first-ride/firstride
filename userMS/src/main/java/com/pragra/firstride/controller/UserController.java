package com.pragra.firstride.controller;

import com.pragra.firstride.entity.UserEntity;
import com.pragra.firstride.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")

public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("add")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user){
         return userService.createUser(user);
    }
    @DeleteMapping("delete/{userId}")
    public ResponseEntity<UserEntity> deleteUser(@PathVariable Integer userId){
        return userService.deleteUser(userId);
    }
    @GetMapping("find/{userId}")
    public ResponseEntity<UserEntity> findUser(@PathVariable Integer userId){
        return userService.findUser(userId);
    }
    @GetMapping("findAll")
    public ResponseEntity<List<UserEntity>> findAll(){
        return userService.findAll();
    }
    @PatchMapping("update/{userId}")
    public ResponseEntity<UserEntity> update(@PathVariable Integer userId,@RequestBody UserEntity user){
        return userService.update(userId,user);
    }



}
