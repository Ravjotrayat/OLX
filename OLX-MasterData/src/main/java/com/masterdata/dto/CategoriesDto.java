package com.masterdata.dto;

public class CategoriesDto {

	private int id;
	
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public CategoriesDto(int id, String status) {
		super();
		this.id = id;
		this.status = status;
	}

	public CategoriesDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "categoriesDto [id=" + id + ", status=" + status + "]";
	}
	
}
