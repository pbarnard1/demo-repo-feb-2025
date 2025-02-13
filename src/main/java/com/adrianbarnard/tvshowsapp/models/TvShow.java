package com.adrianbarnard.tvshowsapp.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="tvshows")
public class TvShow {
	// Primary key - WHY do we NOT include @Column(updatable=false) here?
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	// This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
    @NotBlank(message="Please enter the title of the show!")
    @Size(min=2,max=255,message="Title must be 2 to 255 characters long!")
    private String title;
    
    @NotBlank(message="Please enter who airs the show!")
    @Size(min=2,max=255,message="Network or streamer must be 2 to 255 characters long!")
    private String airer;
    
    @NotNull(message="Please enter the staff count!")
    @Min(value=10, message="The show must employ at least 10 staff members.")
    private Long staffCount;
    
    @NotNull(message="Please state if this show takes place in the present day.")
    private Boolean isPresentDay;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @PastOrPresent(message="The premiere date cannot be in the future.")
    private Date premiereDate;
    
    @Column(columnDefinition="TEXT")
    @Size(min=5, message="Description must be 5 or more characters long.")
    private String description;  
    
    @NotBlank(message="Please give a rating for this show!")
    private String rating;
    
    // Constructor (zero-argument one by convention)
    public TvShow() {}
    
    // Getters and setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAirer() {
		return airer;
	}
	public void setAirer(String airer) {
		this.airer = airer;
	}
	public Long getStaffCount() {
		return staffCount;
	}
	public void setStaffCount(Long staffCount) {
		this.staffCount = staffCount;
	}
	public Boolean getIsPresentDay() {
		return isPresentDay;
	}
	public void setIsPresentDay(Boolean isPresentDay) {
		this.isPresentDay = isPresentDay;
	}
	public Date getPremiereDate() {
		return premiereDate;
	}
	public void setPremiereDate(Date premiereDate) {
		this.premiereDate = premiereDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
    
    
}
