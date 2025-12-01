package com.demo.beans;

public class MyUser { 
	private int id;
	private String uname;
	private String email;
	private String role;
	
	public MyUser() {
		super();
	}

	public MyUser(int id, String uname, String email, String role) {
		super();
		this.id = id;
		this.uname = uname;
		this.email = email;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "MyUser [id=" + id + ", uname=" + uname + ", email=" + email + ", role=" + role + "]";
	}
	
	
	

}
