package com.javahub.cpanel.SpringBootCpanel.POJO;

import org.springframework.stereotype.Component;

@Component		
public class User_table {
	
	private int user_id=0;
	private String user_first_name="";
	private String user_last_name="";
	private String user_gender="";
	private int user_address_id=0;
	private String user_address="";
	private String date_of_birth="";
	
	
    public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	public String getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_first_name() {
		return user_first_name;
	}
	public void setUser_first_name(String user_first_name) {
		this.user_first_name = user_first_name;
	}
	public String getUser_last_name() {
		return user_last_name;
	}
	public void setUser_last_name(String user_last_name) {
		this.user_last_name = user_last_name;
	}
	public String getUser_gender() {
		return user_gender;
	}
	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}
	public int getUser_address_id() {
		return user_address_id;
	}
	public void setUser_address_id(int user_address_id) {
		this.user_address_id = user_address_id;
	}
	public int getUser_type() {
		return user_type;
	}
	public void setUser_type(int user_type) {
		this.user_type = user_type;
	}
	public String getUser_creation_time() {
		return user_creation_time;
	}
	public void setUser_creation_time(String user_creation_time) {
		this.user_creation_time = user_creation_time;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	private int user_type;
	private String user_creation_time;
	private String user_password;
	

}
