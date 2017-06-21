package com.example.restcontrolleradvice.service;

import com.example.restcontrolleradvice.exception.NotFoundException;
import com.example.restcontrolleradvice.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;

@Service
public class UserService {

	private static final HashMap<Integer, User> USER_DATA;

	static {
	    USER_DATA = new LinkedHashMap<>();
        USER_DATA.put(1, new User(1, "Alex"));
		USER_DATA.put(2, new User(2, "Ben"));
	}

	public User getUser(final Integer id)
	{
		final User user = USER_DATA.get(id);

		if ( user == null )
		{
			throw new NotFoundException(String.format("User not found with ID %s", id));
		}

		return user;
	}
}
