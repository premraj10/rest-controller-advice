package com.example.restcontrolleradvice.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.restcontrolleradvice.model.User;
import com.example.restcontrolleradvice.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/users")
public class UserController {



	private static final Logger log = LoggerFactory.getLogger(UserController.class);

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

	@PostMapping(path = "/add", consumes = "application/json")
	public User addMember(@RequestBody User user) {
		log.info("request body {}",user);
		return user;
	}

	@PostMapping(path = "/add2")
	public User addMember2(@RequestBody Object user) throws IOException {
		log.info("request body {}",user);
		ObjectMapper mapper = new ObjectMapper();
		String writeValueAsString = mapper.writeValueAsString(user);
		log.info("writeValueAsString {}",writeValueAsString);
		User user2 = mapper.readValue(mapper.writeValueAsString(user), User.class);
		log.info("user2 {}",user2);
		return user2;
	}

	@PostMapping(path = "/add3")
	public User addMember2(@RequestBody byte[] src) throws IOException {
		log.info("request body {}",src);
		ObjectMapper mapper = new ObjectMapper();
		User user2 = mapper.readValue(src, User.class);
		log.info("user2 {}",user2);
		return user2;
	}



}