package com.example.restcontrolleradvice.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserControllerTest {

    @Autowired
    private UserController userController;

    private MockMvc mockMvc;

    @Before
    public void setUp()
    {
        mockMvc = standaloneSetup(userController).build();
    }

    @Test
    public void testReturnsSuccess() throws Exception
    {
        mockMvc.perform(get("/users/1")).andExpect(status().isOk());
    }

    @Test
    public void testReturnsServerError() throws Exception
    {
        mockMvc.perform(get("/users/3")).andExpect(status().isNotFound());
    }
}
