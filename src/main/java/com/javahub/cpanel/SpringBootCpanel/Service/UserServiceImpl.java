package com.javahub.cpanel.SpringBootCpanel.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javahub.cpanel.SpringBootCpanel.Dao.UserDao;
import com.javahub.cpanel.SpringBootCpanel.POJO.User_table;

@Component
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	
	@Override
	public User_table saveUser(String username, String password) {
		
		return userDao.getAllUsers();
	}

	@Override
	public User_table getUsers() {
		// TODO Auto-generated method stub
		return userDao.getUsers();
	}

	@Override
	public int createUsers(User_table user) {
		// TODO Auto-generated method stub
		return userDao.createUsers(user);
	}

	@Override
	public int updateUsers(User_table user) {
		// TODO Auto-generated method stub
		return userDao.updateUsers(user);
	}

	@Override
	public int deleteUsers(String username) {
		// TODO Auto-generated method stub
		return userDao.deleteUsers(username);
	}

	@Override
	public List<User_table> getAllUsersFromDB() {
		// TODO Auto-generated method stub
		return userDao.getAllUsersFromDB();
	}

	@Override
	public List<User_table> searchUsers(User_table userObj) {
		// TODO Auto-generated method stub
		return userDao.searchUsers(userObj);
	}

	

}
