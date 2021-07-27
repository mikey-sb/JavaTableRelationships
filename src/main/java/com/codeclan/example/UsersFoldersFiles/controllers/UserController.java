package com.codeclan.example.UsersFoldersFiles.controllers;

import com.codeclan.example.UsersFoldersFiles.models.File;
import com.codeclan.example.UsersFoldersFiles.models.Folder;
import com.codeclan.example.UsersFoldersFiles.models.User;
import com.codeclan.example.UsersFoldersFiles.repositories.FolderRepository;
import com.codeclan.example.UsersFoldersFiles.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(value="/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity<Optional<User>> getUser(@PathVariable Long id){
        return new ResponseEntity<>(userRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/users")
    public ResponseEntity<User> postPirate(@RequestBody User user){
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
