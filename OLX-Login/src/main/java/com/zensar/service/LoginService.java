package com.zensar.service;


import java.util.List;

import com.zensar.dto.User;

public interface LoginService {
	public String authenticate(User user);

	public boolean logout(String authToken);

	public User registerUser(User user);

	public User getUserById(int id);
	
	public User getUser(String authToken);

	public String validateToken(String authToken);

//	public User getUser();



}