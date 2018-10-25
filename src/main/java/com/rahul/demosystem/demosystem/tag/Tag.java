package com.rahul.demosystem.demosystem.tag;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

import static com.rahul.demosystem.demosystem.tag.IsActive.N;

@Entity
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tag_id")
    private int tagId;

    @NotEmpty(message = "The description can't be empty")
    @Length(max = 200, message = "Description must be less than 200 characters.")
    @Column(nullable = false)
    private String description;


    @Column(name = "is_active")
    private IsActive isActive = N;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on")
    private Date createdOn = new Date();

    /********************************* Constructor *********************************/

    public Tag(){}

    public Tag(int tagId, String description, IsActive isActive) {
        this.tagId = tagId;
        this.description = description;
        this.isActive = isActive;
    }

    /***************************** Getters & Setters *****************************/

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public IsActive isActive() {
        return isActive;
    }

    public void setActive(IsActive active) {
        isActive = active;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    /***************************** toString method ******************************/

    @Override
    public String toString() {
        return "Tag{" +
                "tagId=" + tagId +
                ", description='" + description + '\'' +
                ", isActive=" + isActive +
                ", createdOn=" + createdOn +
                '}';
    }
}
