package com.rahul.demosystem.demosystem.protocol;


import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.validation.constraints.NotEmpty;

import java.util.Date;

@Entity
@Table(name = "protocols")
public class Protocol {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "protocol_id")
    private int protocolId;


    @NotEmpty(message = "The title can't be empty")
    @Length(max = 200, message = "Title must be less than 200 characters.")
    private String title;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on")
    private Date createdOn = new Date();


    @NotEmpty(message = "The title can't be empty")
    @Column(name = "effective_date")
    private Date effectiveDate;



    /********************************* Constructor *********************************/

    public Protocol(){}

    public Protocol(int protocolId, String title, Date effectiveDate) {
        this.protocolId = protocolId;
        this.title = title;
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
