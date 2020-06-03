/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmuebles.riife.controller;

import com.inmuebles.riife.dao.UserDAO;
import com.inmuebles.riife.entity.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Edward Reyes
 */
@RestController
@RequestMapping("users")
public class UsuariosController {
    
    @Autowired
    private UserDAO userDAO;
    
    @GetMapping
    public ResponseEntity<List<User>> getAll(){
        
    List<User> users = userDAO.findAll();
    return ResponseEntity.ok(users);
    }
    
    @GetMapping("{userId}")
    public ResponseEntity<User> getUsuarioById(@PathVariable("userId") int id){
    Optional<User> optionalUser = userDAO.findById(id);
    return optionalUser.isPresent() 
            ? ResponseEntity.ok(optionalUser.get()) 
            : ResponseEntity.noContent().build();
    }
    
    @PostMapping
    public ResponseEntity<User> createUsuario(@RequestBody User user){
    User newUser = userDAO.save(user);
    return ResponseEntity.ok(newUser);
    }
    
    @PutMapping
    public ResponseEntity<User> updateUsuario(@RequestBody User user){
    Optional<User> optionalUser = userDAO.findById(user.getNoUsuario());
    if(optionalUser.isPresent())
        userDAO.save(user);
    return optionalUser.isPresent() ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("{userId}")
    public ResponseEntity<Void> deleteUsuarioById(@PathVariable("userId") int id){
    userDAO.deleteById(id);
    return ResponseEntity.ok(null);
    }
    
}
