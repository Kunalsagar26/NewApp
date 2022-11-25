package com.javahub.cpanel.SpringBootCpanel;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.javahub.cpanel.SpringBootCpanel.POJO.User_table;
import com.javahub.cpanel.SpringBootCpanel.Service.UserService;

import java.util.logging.*;

@Controller
public class MainController {
	
	private static final Logger LOGGER = Logger.getLogger(MainController.class.getName());
	
	@Autowired
	User_table userTable;
	
	@Autowired
	UserService userService;

	@RequestMapping("/")
	public ModelAndView loginPage() 
	{
		
		try {
			System.out.println("LOGIN PAGE");
		}
		catch(Exception e ) {
			e.printStackTrace();	
		}
		return new ModelAndView("userDashboard");
	}
	
	
	
	

	@RequestMapping(value="/validateUser",method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView validatingUser(HttpSession session , HttpServletRequest request)throws IOException,InterruptedException 
	{
		
		HttpSession mySession = request.getSession();
		LOGGER.info("Creating Session for the user as its validated.");
		String email = request.getParameter("userid");
		String pass = request.getParameter("password");
		System.out.println("\n\n These are the parameteres Email-> "+email+"  Pass"+pass+"  \n\n");
		try {
			
			User_table userTable = new User_table();
			userTable = userService.getUsers();
			System.out.println("THIS IS CALL FOR DB ENDED FROM THE BACKEDN ");
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("userDashboard");
	}
	
	
	@RequestMapping(value="/method1",method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView method1(HttpSession session , HttpServletRequest request)throws IOException,InterruptedException 
	{
		
		HttpSession mySession = request.getSession();
		System.out.println("\n\n METHOD 1");
		try {
			
			System.out.println(" ");
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("dashboard");
	}
	
	
	
	
	
	
	
	@RequestMapping(value="/method2",method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView method2(HttpSession session , HttpServletRequest request)throws IOException,InterruptedException 
	{
		
		HttpSession mySession = request.getSession();
		System.out.println("\n\n METHOD 2");
		try {
			
			System.out.println(" ");
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
		return new ModelAndView("userDashboard");
	}
	
	
	
	
	
	
	
	
	@RequestMapping(value="/method3",method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView method3(HttpSession session , HttpServletRequest request)throws IOException,InterruptedException 
	{
		
		HttpSession mySession = request.getSession();
		System.out.println("\n\n METHOD 3");
		try {
			
			System.out.println(" ");
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("userDashboard");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value="/logout",method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView logout(HttpSession session , HttpServletRequest request) throws IOException,InterruptedException 
	{
		
		HttpSession mySession = request.getSession();

		try {
			
			
			
			System.out.println("I am removing sesssion ");		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("userDashboard");
	}
	
}
