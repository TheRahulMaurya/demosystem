package com.rahul.demosystem.demosystem.device;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;

import com.rahul.demosystem.demosystem.protocol.Protocol;
import com.rahul.demosystem.demosystem.user.User;

import org.hibernate.validator.constraints.Length;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


import java.util.ArrayList;

import java.util.List;


import static com.rahul.demosystem.demosystem.device.Status.Idle;


@JsonIdentityInfo(generator = PropertyGenerator.class, 
				property  = "deviceId", 
				scope     = Device.class)
@Entity
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="device_id")
    private int deviceId;
    


    @Length(max = 500, message = "Description must be less than 500 characters.")
    @Column(name="description" , nullable = false)
    private String description = "None";

    

    @Enumerated(EnumType.STRING)  
    @Column(name = "status", nullable = false)
    private Status status = Idle;


    
    //FetchType.LAZY is used when we don't want to show all the details of user
    //JsonManagedReference is used to prevent from infinite loop
    @ManyToMany(cascade = {
            CascadeType.MERGE
            })
    @JoinTable(
                name = "device_user_map",
                joinColumns = {@JoinColumn(name = "device_id", referencedColumnName = "device_id" )},
                inverseJoinColumns = {@JoinColumn(name = "operator_id" , referencedColumnName = "user_id")}
                )
    private List<User> users = new ArrayList<User>();

    

    @OneToMany(mappedBy = "device" ,cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private List<Protocol> protocols ;


    
    /********************************* Constructor *********************************/
    
    
    public Device(){}

    public Device(String description, Status status, List<User> users, List<Protocol> protocols) {
        this.description = description;
        this.status = status;
        this.users = users;
        this.protocols = protocols;
    }
    
    

    /***************************** Getters & Setters *****************************/
    
    
    

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

  

    public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}



    public List<Protocol> getProtocols() {
		return protocols;
	}

	public void setProtocols(List<Protocol> protocols) {
		this.protocols = protocols;
	}

	/***************************** toString method for testing purpose **************************/

    @Override
    public String toString() {
        return "Device{" +
                "deviceId=" + deviceId +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", users=" + users +
                ", protocols=" + protocols +
                '}';
    }
}
