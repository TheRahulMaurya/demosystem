package com.rahul.demosystem.demosystem.user;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;

import com.rahul.demosystem.demosystem.device.Device;
import com.rahul.demosystem.demosystem.tag.Tag;
import org.hibernate.validator.constraints.Length;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import java.util.*;


@JsonIdentityInfo(generator = PropertyGenerator.class, 
property  = "userId", 
scope     = User.class)
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


    @JsonProperty(access = Access.WRITE_ONLY)
    @NotEmpty(message = "The email can't be empty")
    @Length(max = 200, message = "Email must be less than 200 characters.")
    @Email(message = "Please provide a valid e-mail")
    @Column(name = "email", nullable = false , unique = true)
    private String email;

    
    //JsonBackReference is used to prevent from infinite loop
    @ManyToMany(mappedBy = "users")
//    @JsonBackReference
    private List<Device> devices = new ArrayList<Device>();


    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "tag_id")
    private Tag tag;


    /********************************* Constructor *********************************/

    public User(){}

    public User(int userId, String userName, String email, List<Device> devices, Tag tag) {
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

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    /***************************** toString method for testing purpose******************************/

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


    /****************************** Equals Method for Comparison between two objects ****************************/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(email, user.email) &&
                Objects.equals(devices, user.devices) &&
                Objects.equals(tag, user.tag);
    }


}
