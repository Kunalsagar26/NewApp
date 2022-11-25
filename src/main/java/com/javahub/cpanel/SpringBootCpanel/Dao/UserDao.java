package com.javahub.cpanel.SpringBootCpanel.Dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.javahub.cpanel.SpringBootCpanel.POJO.User_table;

@Component
public interface UserDao {

	public User_table getAllUsers();
	
	public User_table getUsers();
	
	public int createUsers(User_table user);
	public int updateUsers(User_table user);
	public int deleteUsers(String username);
	public List<User_table> getAllUsersFromDB();
	public List<User_table>  searchUsers(User_table userObj);


}
