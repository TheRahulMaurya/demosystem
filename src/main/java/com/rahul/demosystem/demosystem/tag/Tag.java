package com.rahul.demosystem.demosystem.tag;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Date;

import static com.rahul.demosystem.demosystem.tag.IsActive.N;

@Entity
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tag_id")
    private int tagId;

    
    @Length(max = 200, message = "Description must be less than 200 characters.")
    @Column(name="description", nullable = false)
    private String description;


    @Enumerated(EnumType.STRING)
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


    public IsActive getIsActive() {
		return isActive;
	}

	public void setIsActive(IsActive isActive) {
		this.isActive = isActive;
	}

	public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    /***************************** toString method for testing purpose ******************************/

    @Override
    public String toString() {
        return "Tag{" +
                "tagId=" + tagId +
                ", description='" + description + '\'' +
                ", isActive=" + isActive +
                ", createdOn=" + createdOn +
                '}';
    }


    /******************************** Equals Method for Comparison between two objects **************************************/
    
    
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tag other = (Tag) obj;
		if (createdOn == null) {
			if (other.createdOn != null)
				return false;
		} else if (!createdOn.equals(other.createdOn))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (isActive != other.isActive)
			return false;
		if (tagId != other.tagId)
			return false;
		return true;
	}
    
    
    
}
