package com.rahul.demosystem.demosystem.user;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @NotEmpty(message = "The Username can't be empty")
    @Length(max = 500, message = "Username must be less than 500 characters.")
    private String userName;

    @NotEmpty(message = "The title can't be empty")
    @Length(max = 200, message = "Title must be less than 200 characters.")
    private String email;

    private int deviceId;

    private int tagId;


    /********************************* Constructor *********************************/

    public User(){}

    public User(int userId, String userName, String email, int deviceId, int tagId) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.deviceId = deviceId;
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

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
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
                ", deviceId=" + deviceId +
                ", tagId=" + tagId +
                '}';
    }
}
