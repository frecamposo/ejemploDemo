package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    // grabar
    public User saveUser(User usu){
        return userRepository.save(usu);
    }
    // listar todo
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    // buscar solo uno
    public User findUser(Long id){
        return userRepository.findById(id).orElse(null);
    }
    //eliminar
    public boolean deleteUser(Long id){
        userRepository.deleteById(id);
        return true;
    }
}
