package com.rahul.demosystem.demosystem.user;



import com.rahul.demosystem.demosystem.device.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.rahul.demosystem.demosystem.tag.Tag;
import com.rahul.demosystem.demosystem.user.service.UserService;

import java.io.IOException;


@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserRepository userRepository ;
    
    @Autowired
    UserService userService;

    @Autowired
    DeviceRepository deviceRepository;

    
    //Show all users
    @ResponseBody
    @GetMapping("/all")
    public Iterable<User> allUsers()
    {
        Iterable<User> userList = userRepository.findAll();

        return userList;
    }
    
    
    //Create a user
    @PostMapping("/create")
    public Iterable<User> createUser(@RequestBody User user) throws IOException
    {
    	//validate user
		userService.validateUser(user);

		userRepository.save(user);

		//just for convenience
    	Iterable<User> userList = userRepository.findAll();

        return userList;
    }
    
    
    //Assign a tag to a user
    @PutMapping("/assignTag/{userId}")
    public Iterable<User> assignTag( @PathVariable("userId") int userId, @RequestBody Tag tag) throws IOException
    {

    	User user = userRepository.findById(userId).orElse(null);

    	//check if user already have a tag ?
    	if(user.getTag() != null)
    		throw new IOException("User Already have a tag..");

    	user.setTag(tag);

        //validate if this tag is assign to another user or not
    	User oldUser = userRepository.findByTag(tag).orElse(null);

    	if( oldUser != null)
    		throw new IOException("Already assigned tag to another user");

    	//check if the tag is active or not
        if( tag.getIsActive().equals("N") )
            throw new IOException("Tag is not active..");

    	userRepository.save(user);

    	Iterable<User> userList = userRepository.findAll();

        return userList;
    }


    //update existing user
    @PutMapping("/update")
    public Iterable<User> updateUser(@RequestBody User user) throws IOException {

        //This throw exception if user does not exist
        userService.userExistOrNot(user.getUserId());

        userRepository.save(user);


        Iterable<User> userList = userRepository.findAll();

        return userList;
    }


    //Delete existing user via user id
    @DeleteMapping("/delete/{userId}")
    public Iterable<User> deleteUser(@PathVariable("userId") int userId) throws IOException {


        //This throw exception if user does not exist
        userService.userExistOrNot(userId);


        userRepository.deleteById(userId);

        Iterable<User> userList = userRepository.findAll();

        return userList;


    }


    

}
