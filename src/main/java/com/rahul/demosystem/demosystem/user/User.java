package com.rahul.demosystem.demosystem.user;

import com.fasterxml.jackson.annotation.*;
import com.rahul.demosystem.demosystem.device.Device;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "userId")
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


    //JsonManagedReference & JsonBackReference is used to prevent from infinite loop
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "users")
    @JsonBackReference
    private Set<Device> devices = new HashSet<Device>();


    @Column(name = "tag_id")
    private int tagId;


    /********************************* Constructor *********************************/

    public User(){}

    public User(int userId, String userName, String email, Set<Device> devices, int tagId) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.devices = devices;
        this.tagId = tagId;
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

    public Set<Device> getDeviceId() {
        return devices;
    }

    public void setDeviceId(Set<Device> deviceId) {
        this.devices = devices;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    /***************************** toString method ******************************/

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", devices=" + devices +
                ", tagId=" + tagId +
                '}';
    }
}
