package com.javahub.cpanel.SpringBootCpanel.Service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.javahub.cpanel.SpringBootCpanel.POJO.User_table;

@Component
public interface UserService {

    public User_table saveUser(String username, String password);
    public User_table getUsers();
    public int createUsers(User_table user);
    public int updateUsers(User_table user);
    public int deleteUsers(String username);
    public List<User_table> getAllUsersFromDB();
	public List<User_table> searchUsers(User_table userObj);


    
}
