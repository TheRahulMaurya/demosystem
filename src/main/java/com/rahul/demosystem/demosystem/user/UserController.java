package com.rahul.demosystem.demosystem.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserRepository userRepository ;

    @ResponseBody
    @RequestMapping(value = "/all" , method = RequestMethod.GET)
    public Iterable<User> allUsers()
    {
        Iterable<User> userList = userRepository.findAll();

        return userList;
    }

}
