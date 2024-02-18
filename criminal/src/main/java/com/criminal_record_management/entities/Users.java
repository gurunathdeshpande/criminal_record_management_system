package com.criminal_record_management.entities;

public class Users {
	private int userId;
    private String userName;
    private String userEmail;
    private String password;
    private String gender;
    private String dob;
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(int userId, String userName, String userEmail, String password, String gender, String dob) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.password = password;
		this.gender = gender;
		this.dob = dob;
	}
	public Users(String userName, String userEmail, String password, String gender, String dob) {
		super();
		this.userName = userName;
		this.userEmail = userEmail;
		this.password = password;
		this.gender = gender;
		this.dob = dob;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
    
    

}
