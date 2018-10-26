package com.rahul.demosystem.demosystem.user.service;

import java.io.IOException;

import com.rahul.demosystem.demosystem.user.User;

public interface UserService {
	
	User validateUser(User user) throws IOException;
	
	
}
