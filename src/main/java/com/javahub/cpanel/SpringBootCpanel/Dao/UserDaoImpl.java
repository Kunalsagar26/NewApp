package com.javahub.cpanel.SpringBootCpanel.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.javahub.cpanel.SpringBootCpanel.POJO.User_table;

@Component
public class UserDaoImpl implements UserDao {
	
	
	
	@Autowired
	User_table userTable;

	
	@Autowired 
	DataSource dataSource;

	public void setDataSource(DataSource ds) {
        dataSource = ds;
    }
	
	@Override
	public User_table getAllUsers() 
	{
			String sql = "SELECT * FROM user_table WHERE user_id = ?";
		    Connection conn = null;
		    User_table emp = new User_table();
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, 1);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String name = rs.getString("user_name");
				String email = rs.getString("user_email");
				String address = rs.getString("user_address");
				System.out.print("\n this is the name " + name + "\n");
				/*
				 * emp.setUser_name(name); emp.setUser_email(email);
				 * emp.setUser_address(address);
				 */
				// customer = new Employee(rs.getInt("CUST_ID"), rs.getString("NAME"),
				// rs.getInt("Age"));
			}
			rs.close();
			ps.close();

		} 
		catch (SQLException e) 
		{
			throw new RuntimeException(e);
		} 
		finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		
		return emp;
	}
	
	
	
	
	@Override
	public User_table getUsers() 
	{
			String sql = "SELECT * FROM user_table WHERE user_id = 1";
		    Connection conn = null;
		    User_table emp = new User_table();
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String name = rs.getString("user_name");
				System.out.print("\n THIS IS FROM THE DATABASE OF MOCHAHOST " + name + "\n");
				/*
				 * emp.setUser_name(name); emp.setUser_email(email);
				 * emp.setUser_address(address);
				 */
				// customer = new Employee(rs.getInt("CUST_ID"), rs.getString("NAME"),
				// rs.getInt("Age"));
			}
			rs.close();
			ps.close();

		} 
		catch (SQLException e) 
		{
			throw new RuntimeException(e);
		} 
		finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		
		return emp;
	}
	
	
	
	
	
	
	
	
	
	@Override
	public int createUsers(User_table user)
	{
		
	int success = 0;
	String sql = "Insert INTO users (user,gender,date_of_birth,address) VALUES (?,?,?,?)";
	Connection conn = null;
	User_table emp = new User_table();
	try {
	     conn = dataSource.getConnection();
		 PreparedStatement ps = conn.prepareStatement(sql);
		 ps.setString(1, user.getUser_first_name());
		 ps.setString(2, user.getUser_gender());
		 ps.setString(3, user.getDate_of_birth());
		 ps.setString(4, user.getUser_address());
		 int rowsInserted = ps.executeUpdate();
		 ps.close();
		 if(rowsInserted>0)
		 {
			 success = 1;
		 }
		 
		} 
		catch (SQLException e) 
		{
			throw new RuntimeException(e);
		} 
		finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return success;
	}
	
	
	
	@Override
	public int updateUsers(User_table user)
	{
		
	int success = 0;
	String sql = "UPDATE users SET (user=?,gender=?,date_of_birth=?,address=?)";
	Connection conn = null;
	try {
	     conn = dataSource.getConnection();
		 PreparedStatement ps = conn.prepareStatement(sql);
		 ps.setString(1, user.getUser_first_name());
		 ps.setString(2, user.getUser_gender());
		 ps.setString(3, user.getDate_of_birth());
		 ps.setString(4, user.getUser_address());
		 int rowsInserted = ps.executeUpdate();
		 ps.close();
		 if(rowsInserted>0)
		 {
			 success = 1;
		 }
		 
		} 
		catch (SQLException e) 
		{
			throw new RuntimeException(e);
		} 
		finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return success;
	}
	
	
	
	@Override
	public int deleteUsers(String username)
	{
		
	int success = 0;
	String sql = "DELETE FROM users WHERE username=?";
	Connection conn = null;
	try {
	     conn = dataSource.getConnection();
		 PreparedStatement ps = conn.prepareStatement(sql);
		 ps.setString(1, username);
		 int rowsInserted = ps.executeUpdate();
		 ps.close();
		 if(rowsInserted>0)
		 {
			 success = 1;
		 }
		 
		} 
		catch (SQLException e) 
		{
			throw new RuntimeException(e);
		} 
		finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return success;
	}
	
	
	
	
	
	@Override
	public List<User_table> getAllUsersFromDB()
	{
	int success = 0;
	String sql = "select * from users a ORDER a.user_id LIMIT 10 OFFSET 10";
	Connection conn = null;
	 List<User_table> list = new ArrayList<User_table>();
	 
	try {
	     conn = dataSource.getConnection();
		 PreparedStatement ps = conn.prepareStatement(sql);
		 ResultSet rs = ps.executeQuery();
		 if (rs.next()) 
		 {
			 User_table user = new User_table();
			user.setUser_first_name(rs.getString("user_first_name"));
			user.setUser_gender(rs.getString("user_gender"));
			user.setDate_of_birth(rs.getString("date_of_birth"));
			user.setUser_address(rs.getString("user_address"));
			list.add(user);
		 }
		 
		} 
		catch (SQLException e) 
		{
			throw new RuntimeException(e);
		} 
		finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return list;
	}
	
	
	
	
	@Override
	public List<User_table>  searchUsers(User_table userObj)
	{
	int success = 0;
	
	String name ="";
	String adress = "";
	String dob = "";
	String gender="";
	
	String sql = "select * from user_table  where ("+ name + adress + dob +gender+")";
	
	
	if(userObj.getUser_first_name()!="")
	{
		 name= "user_first_name  like "+"'" +userObj.getUser_first_name()+"'";
	}
	if(userObj.getUser_address()!="")
	{
		adress= "user_first_name  like "+"'" +userObj.getUser_address()+"'";
	}
	if(userObj.getDate_of_birth()!="")
	{
		dob= "user_first_name  like "+"'" +userObj.getDate_of_birth()+"'";
	}
	if(userObj.getUser_gender()!="")
	{
		gender= "user_first_name  like "+"'" +userObj.getUser_gender()+"'";
	}
	
	//String sql = "select * from users a ORDER a.user_id LIMIT 10 OFFSET 10";
	Connection conn = null;
	 List<User_table> list = new ArrayList<User_table>();
;	try {
	     conn = dataSource.getConnection();
		 PreparedStatement ps = conn.prepareStatement(sql);
		 ResultSet rs = ps.executeQuery();
		 if (rs.next()) 
		 {
			 User_table user = new User_table();
			user.setUser_first_name(rs.getString("user_first_name"));
			user.setUser_gender(rs.getString("user_gender"));
			user.setDate_of_birth(rs.getString("date_of_birth"));
			user.setUser_address(rs.getString("user_address"));
			list.add(user);
		 }
		 
		} 
		catch (SQLException e) 
		{
			throw new RuntimeException(e);
		} 
		finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
