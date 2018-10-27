package com.rahul.demosystem.demosystem.user;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rahul.demosystem.demosystem.tag.Tag;



@Repository
public interface UserRepository extends CrudRepository<User , Integer> {
	
	//Return user matching to this email
	Optional<User> findByEmail(String email);
	
	Optional<User> findByTag(Tag tag);
	
	
}
