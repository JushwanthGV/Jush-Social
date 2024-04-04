package com.jush.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Story {
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idInteger;
	
	@ManyToOne
	private User user;
	
	private String image;
	
	private String captions;
	
	private LocalDateTime timestamp;
	
	public Story() {
		// TODO Auto-generated constructor stub
	}

	public Story(Integer idInteger, User user, String image, String captions, LocalDateTime timestamp) {
		super();
		this.idInteger = idInteger;
		this.user = user;
		this.image = image;
		this.captions = captions;
		this.timestamp = timestamp;
	}

	public Integer getIdInteger() {
		return idInteger;
	}

	public void setIdInteger(Integer idInteger) {
		this.idInteger = idInteger;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCaptions() {
		return captions;
	}

	public void setCaptions(String captions) {
		this.captions = captions;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	
	
	
	
}
