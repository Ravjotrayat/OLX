package com.advertise.entity;

import java.util.Arrays;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "ADVERTISES")
public class AdvertiseEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "status")
	private int status;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "description")
	private String description;
	
	@Lob
	private byte[] photo;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "created_date") //,updatable = false
	private int created_date;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "modified_date")
	private int modified_date;
	
	@Column(name = "active")
	private boolean active;
	
	@Column(name = "posted_by")
	private String posted_by;
	
	@Column(name = "username")
	private String username;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public int getCreated_date() {
		return created_date;
	}

	public void setCreated_date(int created_date) {
		this.created_date = created_date;
	}

	public int getModified_date() {
		return modified_date;
	}

	public void setModified_date(int modified_date) {
		this.modified_date = modified_date;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getPosted_by() {
		return posted_by;
	}

	public void setPosted_by(String posted_by) {
		this.posted_by = posted_by;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public AdvertiseEntity(int id, String title, String category, int status, double price, String description,
			byte[] photo, int created_date, int modified_date, boolean active, String posted_by, String username) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.status = status;
		this.price = price;
		this.description = description;
		this.photo = photo;
		this.created_date = created_date;
		this.modified_date = modified_date;
		this.active = active;
		this.posted_by = posted_by;
		this.username = username;
	}

	public AdvertiseEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "AdvertiseEntity [id=" + id + ", title=" + title + ", category=" + category + ", status=" + status
				+ ", price=" + price + ", description=" + description + ", photo=" + Arrays.toString(photo)
				+ ", created_date=" + created_date + ", modified_date=" + modified_date + ", active=" + active
				+ ", posted_by=" + posted_by + ", username=" + username + "]";
	}
	
	
}
