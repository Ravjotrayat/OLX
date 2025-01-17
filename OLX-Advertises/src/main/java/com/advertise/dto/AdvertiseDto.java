package com.advertise.dto;


public class AdvertiseDto {

	private int id;
	private String title;
	private String category;
	private int status;
	private double price;
	private String description;
	private byte[] photo;
	private int created_date;
	private int modified_date;
	private boolean active;
	private String posted_by;
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
	
	
	
	public AdvertiseDto(int id, String title, String category, int status, double price, String description,
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
	public AdvertiseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "AdvertiseDto [id=" + id + ", title=" + title + ", category=" + category + ", status=" + status
				+ ", price=" + price + ", description=" + description + ", photo=" + photo + ", created_date="
				+ created_date + ", modified_date=" + modified_date + ", active=" + active + ", posted_by=" + posted_by
				+ ", username=" + username + "]";
	}
	
	
}
