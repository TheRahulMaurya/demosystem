package com.rahul.demosystem.demosystem.device;

import com.fasterxml.jackson.annotation.*;
import com.rahul.demosystem.demosystem.user.User;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import java.util.HashSet;
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


    //FetchType.LAZY is used when we don't want all the details of user
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
            CascadeType.ALL
            })
    @JoinTable(
                name = "device_user_map",
                joinColumns = {@JoinColumn(name = "device_id" , referencedColumnName = "device_id")},
                inverseJoinColumns = {@JoinColumn(name = "operator_id" ,referencedColumnName = "user_id")}
                )
    private Set<User> users = new HashSet<User>();


    @Column(name = "protocol_id")
    private int protocolId;


    /********************************* Constructor *********************************/
    public Device(){}

    public Device(String description, Status status, Set<User> users, int protocolId) {
        this.description = description;
        this.status = status;
        this.users = users;
        this.protocolId = protocolId;
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

    public Set<User> getOperatorId() {
        return users;
    }

    public void setOperatorId(Set<User> operatorId) {
        this.users = operatorId;
    }

    public int getProtocolId() {
        return protocolId;
    }

    public void setProtocolId(int protocolId) {
        this.protocolId = protocolId;
    }


    /***************************** toString method **************************/

    @Override
    public String toString() {
        return "Device{" +
                "deviceId=" + deviceId +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", users=" + users +
                ", protocolId=" + protocolId +
                '}';
    }
}
