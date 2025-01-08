package com.masterdata.dto;

public class Adv_statusDto {
	
	private int id;
	
	private String name;
			
	private String description ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Adv_statusDto(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public Adv_statusDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "adv_statusDto [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
	
	
}
