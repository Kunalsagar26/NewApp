package com.javahub.cpanel.SpringBootCpanel;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.javahub.cpanel.SpringBootCpanel.POJO.User_table;
import com.javahub.cpanel.SpringBootCpanel.Service.UserService;


@Controller	
public class HomeController {	

	@Autowired
	User_table userTable;
	
	@Autowired
	UserService userService;
	
	
	public static String filePath = "C:\\Users\\log.txt";
	
	
	public static void writeLogFile(String stringToUpdate)
	{
		
		try {
		      FileWriter myWriter = new FileWriter(filePath);
		      myWriter.write(stringToUpdate);
		      myWriter.close();
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
	}
	
	
	@RequestMapping(value="/createUser",method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView CreateUser(HttpSession session , HttpServletRequest request) throws IOException,InterruptedException 
	{
		ModelAndView model = new ModelAndView("");
		
		try 
		{
			//Getting all the values of the object/fields/parameters.
			String username = request.getParameter("username");
			String gender = request.getParameter("gender");
			String dateOfBirth = request.getParameter("date_of_birth");
			String address = request.getParameter("address");
			
			User_table userTable = new User_table ();
			
			userTable.setUser_first_name(username);
			userTable.setUser_gender(gender);
			userTable.setUser_address(address);
			userTable.setDate_of_birth(dateOfBirth);
			int  success  = userService.createUsers(userTable);
			if(success==0)
			{
				writeLogFile("Failed performing create user  task  with name "+ username);
			}
			else {
				writeLogFile("User has been created with name "+ username);
			}
			System.out.println("Success from Create User"+success);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
		return model;
	}
	
	@RequestMapping(value="/updateUser",method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView updateUser(HttpSession session , HttpServletRequest request) throws IOException,InterruptedException 
	{
		ModelAndView model = new ModelAndView("");
		
		try 
		{
			String username = request.getParameter("username");
			String gender = request.getParameter("gender");
			String dateOfBirth = request.getParameter("date_of_birth");
			String address = request.getParameter("address");
			
			User_table userTable = new User_table ();
			
			userTable.setUser_first_name(username);
			userTable.setUser_gender(gender);
			userTable.setUser_address(address);
			userTable.setDate_of_birth(dateOfBirth);
			int  success  = userService.updateUsers(userTable);
			System.out.println("Success from Update User"+success);
			if(success==0)
			{
				writeLogFile("Failed performing create user  task  with name "+ username);
			}
			else {
				writeLogFile("User has been updated with name "+ username);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
		return model;
	}
	
	
	
	
	@RequestMapping(value="/getAllUsers",method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView getAllUsers(HttpSession session , HttpServletRequest request) throws IOException,InterruptedException 
	{
		ModelAndView model = new ModelAndView("");
		
		try 
		{
			 List<User_table> list = new ArrayList<User_table>();
			 list = userService.getAllUsersFromDB();
			writeLogFile("Request for getting all users is being made from DB");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
		return model;
	}
	
	
	
	
	
	@RequestMapping(value="/deleteUser",method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView deleteAllUsers(HttpSession session , HttpServletRequest request) throws IOException,InterruptedException 
	{
		ModelAndView model = new ModelAndView("");
		
		try 
		{
		
			String username = request.getParameter("user_first_name");
			User_table userTable = new User_table ();
			int  success  = userService.deleteUsers(username);
			System.out.println("Success from delete User"+success);
			writeLogFile("Request for deleting  user is being made for user"+username);
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
		return model;
	}
	
	
	@RequestMapping(value="/searchUser",method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView searchUser(HttpSession session , HttpServletRequest request) throws IOException,InterruptedException 
	{
		ModelAndView model = new ModelAndView("");
		
		try 
		{
			//Getting all the values of the object/fields/parameters.
			String username = request.getParameter("username");
			String gender = request.getParameter("gender");
			String dateOfBirth = request.getParameter("date_of_birth");
			String address = request.getParameter("address");
			User_table userTable = new User_table ();
			List<User_table> list = new ArrayList<User_table>();
			userTable.setUser_first_name(username);
			userTable.setUser_gender(gender);
			userTable.setUser_address(address);
			userTable.setDate_of_birth(dateOfBirth);
			list  = userService.searchUsers(userTable);
			writeLogFile("Request for Searching user is being made for user"+username);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
		return model;
	}
	
}
