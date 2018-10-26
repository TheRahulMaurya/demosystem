package com.rahul.demosystem.demosystem.protocol;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import com.rahul.demosystem.demosystem.device.Device;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.validation.constraints.NotEmpty;

import java.util.Date;

@Entity
public class Protocol {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "protocol_id")
    private int protocolId;


    @NotEmpty(message = "The title can't be empty")
    @Length(max = 200, message = "Title must be less than 200 characters.")
    @Column(nullable = false)
    private String title;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "device_id")
    private Device device;
    


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on")
    private Date createdOn = new Date();


    @NotEmpty(message = "The title can't be empty")
    @Column(name = "effective_date", nullable = false)
    private Date effectiveDate;



    /********************************* Constructors *********************************/

    public Protocol(){}

    public Protocol(int protocolId, String title, Date effectiveDate) {
        this.protocolId = protocolId;
        this.title = title;
        this.effectiveDate = effectiveDate;
    }
    
    

    public Protocol(int protocolId, String title, Device device, Date createdOn, Date effectiveDate) {
		super();
		this.protocolId = protocolId;
		this.title = title;
		this.device = device;
		this.createdOn = createdOn;
		this.effectiveDate = effectiveDate;
	}

	/***************************** Getters & Setters *****************************/

    public int getProtocolId() {
        return protocolId;
    }

    public void setProtocolId(int protocolId) {
        this.protocolId = protocolId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    

    public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    /***************************** toString method **************************/

    @Override
    public String toString() {
        return "Protocol{" +
                "protocolId=" + protocolId +
                ", title='" + title + '\'' +
                ", createdOn=" + createdOn +
                ", effectiveDate=" + effectiveDate +
                '}';
    }
}
