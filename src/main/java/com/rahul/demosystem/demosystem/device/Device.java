package com.rahul.demosystem.demosystem.device;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.rahul.demosystem.demosystem.protocol.Protocol;
import com.rahul.demosystem.demosystem.user.User;
import org.hibernate.validator.constraints.Length;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.rahul.demosystem.demosystem.device.Status.Idle;



@Entity
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="device_id")
    private int deviceId;


    /** @NotNull is a Bean Validation annotation.It has nothing to do with database constraints
     * itself but Hibernate translate this into database constraints for us.
     *
     * But in future if we switch to other ORM then may be it not work that's why
     * for security reasons @Column(nullable = false) is also used.
     */

    @NotEmpty(message = "The description can't be empty")
    @Length(max = 500, message = "Description must be less than 500 characters.")
    @Column(name="description" , nullable = false)
    private String description;


    @Enumerated(EnumType.STRING)
    @NotEmpty(message = "The status can't be empty")
    @Column(name = "status", nullable = false)
    private Status status = Idle;


    //FetchType.LAZY is used when we don't want to show all the details of user
    //JsonManagedReference is used to prevent from infinite loop
    @ManyToMany(cascade = {
            CascadeType.ALL
            })
    @JoinTable(
                name = "device_user_map",
                joinColumns = {@JoinColumn(name = "device_id" )},
                inverseJoinColumns = {@JoinColumn(name = "user_id")}
                )
    @JsonManagedReference
    private Set<User> users = new HashSet<User>();


    @OneToMany(mappedBy = "device")
    private List<Protocol> protocols ; 


    /********************************* Constructor *********************************/
    public Device(){}

    public Device(String description, Status status, Set<User> users, List<Protocol> protocols) {
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

  

    public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}



    public List<Protocol> getProtocols() {
		return protocols;
	}

	public void setProtocols(List<Protocol> protocols) {
		this.protocols = protocols;
	}

	/***************************** toString method **************************/

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
