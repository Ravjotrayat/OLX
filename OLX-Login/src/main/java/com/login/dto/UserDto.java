package com.login.dto;

public class UserDto
{
	private int id;
	private String username;
	private String passsword;
	private String roles;
	private boolean active;
	private String firstname;
	private String lastname;
	private String token;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getRoles() {
		return roles;
	}
	
	public void setRoles(String roles) {
		this.roles = roles;
	}
	
	public boolean isActive() {
		return active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
	
	public String getPasssword() {
		return passsword;
	}

	public void setPasssword(String passsword) {
		this.passsword = passsword;
	}
	
	public UserDto(int id, String username, String passsword, String roles, boolean active, String firstname,
			String lastname, String token) {
		super();
		this.id = id;
		this.username = username;
		this.passsword = passsword;
		this.roles = roles;
		this.active = active;
		this.firstname = firstname;
		this.lastname = lastname;
		this.token = token;
	}
	
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "UserDto [id=" + id + ", username=" + username + ", roles=" + roles + ", active=" + active
				+ ", firstname=" + firstname + ", lastname=" + lastname + ", token=" + token + "]";
	}
}
