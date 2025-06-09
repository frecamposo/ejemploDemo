package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/users")
@Tag(name = "Usuarios",description = "Administracion de Usuarios")
public class UserController {
    
    @Autowired
    private UserService userService;


    // api grabar (POST)
    @PostMapping
    public User grabarUser(@RequestBody User usuario) {
        return userService.saveUser(usuario);                
    }
    // api buscar (GET <id>)
    @GetMapping("/{id}")
    public User buscarUser(@PathVariable Long id) {
        return userService.findUser(id);
    }
    // api listar todo (GET <All>)
    @GetMapping
    public List<User> listarAllUser() {
        return userService.getAllUsers();
    }
    // api eliminar
    @DeleteMapping("/{id}")
    public boolean eliminar(@PathVariable Long id){
        return userService.deleteUser(id);
    }
    

    
}
