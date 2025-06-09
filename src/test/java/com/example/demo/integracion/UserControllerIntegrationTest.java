package com.example.demo.integracion;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.http.*;
import com.example.demo.controller.UserController;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(UserController.class)
public class UserControllerIntegrationTest {
    
    @Autowired
    public MockMvc mockMvc;

    @MockBean
    public UserService userService;
    
    @Test
    void testGetByUser() throws Exception{
        User user = new User(4L, "juanita", "lara", "jl@yahoo.com");

        Mockito.when(userService.findUser(1L)).thenReturn(user);

        mockMvc.perform(get("/api/users/{id}", 1L))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(1L))
            .andExpect(jsonPath("$.nombre").value("juanita"));

    }
}
