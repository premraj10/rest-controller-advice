package com.example.restcontrolleradvice.controller;

import com.example.restcontrolleradvice.model.User;
import com.example.restcontrolleradvice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(final UserService userService)
	{
		this.userService = userService;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable final Integer id)
    {
		return userService.getUser(id);
	}
}