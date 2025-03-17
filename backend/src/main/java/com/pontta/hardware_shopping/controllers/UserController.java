package com.pontta.hardware_shopping.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pontta.hardware_shopping.dto.CreateUserDto;
import com.pontta.hardware_shopping.dto.UserDto;
import com.pontta.hardware_shopping.services.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {
    
    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> findUsersByName(@RequestParam String name){

        List<UserDto> users = userService.findUsersByName(name);

        return new ResponseEntity<>(users, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findUserById(@PathVariable Long id){

        return new ResponseEntity<>(userService.findUserById(id), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody CreateUserDto createUserDto){

        UserDto user = userService.createUser(createUserDto);

        return new ResponseEntity<>(user, HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody CreateUserDto createUserDto){

        UserDto user = userService.updateUser(id, createUserDto);

        return new ResponseEntity<>(user, HttpStatus.OK);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){

        userService.deleteUser(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
