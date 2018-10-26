package com.rahul.demosystem.demosystem.user.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.demosystem.demosystem.user.User;
import com.rahul.demosystem.demosystem.user.UserRepository;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User validateUser(User user) throws IOException{
		
		User oldUser = userRepository.findByEmail( user.getEmail() ).orElse(null);
		
		if( oldUser != null)
		{
			throw new IOException("Email already exist..");
		}
		
		oldUser = userRepository.findByTag( user.getTag() ).orElse(null);
		
		if( oldUser != null)
		{
			throw new IOException("This tag is already assign to another user..");
		}
		
		return user;
	}

}
