package com.rahul.demosystem.demosystem.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import com.rahul.demosystem.demosystem.device.Device;
import com.rahul.demosystem.demosystem.tag.Tag;
import org.hibernate.validator.constraints.Length;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import java.util.HashSet;
import java.util.Set;


@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int userId;

    @NotEmpty(message = "The Username can't be empty")
    @Length(max = 500, message = "Username must be less than 500 characters.")
    @Column(name = "user_name", nullable = false)
    private String userName;


    @JsonIgnore
    @NotEmpty(message = "The email can't be empty")
    @Length(max = 200, message = "Email must be less than 200 characters.")
    @Email(message = "Please provide a valid e-mail")
    @Column(name = "email", nullable = false , unique = true)
    private String email;

    
    //JsonBackReference is used to prevent from infinite loop
    @ManyToMany(mappedBy = "users")
    @JsonBackReference
    private Set<Device> devices = new HashSet<Device>();


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tag_id")
    private Tag tag;


    /********************************* Constructor *********************************/

    public User(){}

    public User(int userId, String userName, String email, Set<Device> devices, Tag tag) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.devices = devices;
        this.tag = tag;
    }

    /***************************** Getters & Setters *****************************/

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Device> getDevices() {
        return devices;
    }

    public void setDevices(Set<Device> devices) {
        this.devices = devices;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    /***************************** toString method ******************************/

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", devices=" + devices +
                ", tag=" + tag +
                '}';
    }
}
