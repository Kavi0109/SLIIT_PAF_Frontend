package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

public class User {
	
	private Connection connect()
	{
		Connection con = null;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
 
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
	
	public String readUsers()
	{
		String output = "";
		
		try
		{
			Connection con = connect();
			
			if (con == null)
			{
				return "Error while connecting to the database for reading.";
			}
 
			// Prepare the html table to be displayed
			output = "<table border='1'><tr><th>Full Name</th><th>Email</th>" +
					 "<th>Password</th>" +
					 "<th>Mobile No</th>" +
					 "<th>Type</th>" +
					 "<th>Account No</th>" +
					 "<th>OTP</th>" +
					 "<th>Status</th>"+
					 "<th>Update</th>"+
					 "<th>Remove</th>";
 
			String query = "select * from users";
			
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery(query);
 
			// iterate through the rows in the result set
			while (rs.next())
			{
				 String id = Integer.toString(rs.getInt("id"));
				 String name = rs.getString("name");
				 String email = rs.getString("email");
				 String password = rs.getString("pass");
				 String mobile = rs.getString("mobile");
				 String type = rs.getString("type");
				 String accountNo = Integer.toString(rs.getInt("accountNo"));
				 String otp = Integer.toString(rs.getInt("otp"));
				 String status = rs.getString("status");
				 
				 // Add into the html table
				 output += "<tr><td><input id='hidItemIDUpdate'name='hidItemIDUpdate'type='hidden' value='" + id+ "'>" + name + "</td>";
				 output += "<td>" + email + "</td>";
				 output += "<td>" + password + "</td>";
				 output += "<td>" + mobile + "</td>";
				 output += "<td>" + type + "</td>";
				 output += "<td>" + accountNo + "</td>";
				 output += "<td>" + otp + "</td>";
				 output += "<td>" + status + "</td>";
 
				// buttons
				 output += "<td><input name='btnUpdate'type='button' value='Update'class='btnUpdate btn btn-secondary'></td>"+ "<td><input name='btnRemove' type='button' value='Remove'class='btnRemove btn btn-danger' data-id='"+ id + "'>" + "</td></tr>";
			}
 
			con.close();
 
			// Complete the html table
			output += "</table>";
		}
 
		catch (Exception e)
		{
			output = "Error while reading the items.";
			System.err.println(e.getMessage());
		}
 
		return output;
	}
	
	
	public String insertUser(String name, String email,String pass, String mobile, String type)
    {
		String output = "";
		int otp = new Random().nextInt(345);
		int accountNo = new Random().nextInt(100000000);

		try
		{
			Connection con = connect();
			
			if (con == null)
			{
				return "Error while connecting to the database for inserting.";
			}
 
			// create a prepared statement
			String query = "insert into users(id,name,email,pass,mobile,type,accountNo,otp,status)values(?,?,?,?,?,?,?,?,?)";
		 
			PreparedStatement ps = con.prepareStatement(query);
		 
			// binding values
			ps.setInt(1, 0);
			ps.setString(2, name);
			ps.setString(3, email);
			ps.setString(4, pass);
			ps.setString(5, mobile);
			ps.setString(6, type);
			ps.setInt(7, accountNo);
			ps.setInt(8, otp);
			ps.setString(9, "Active");
		 
			// execute the statement
			ps.execute();
			con.close();
			String newUsers = readUsers();
			output = "{\"status\":\"success\", \"data\": \"" +newUsers + "\"}";
		 }
		
		 catch (Exception e)
		 {
			 output = "{\"status\":\"error\", \"data\":\"Error while inserting the item.\"}";
			 System.err.println(e.getMessage());
		 }
		
		 return output;
		 
		 }
	
	public String updateUser(String id, String name, String email,String pass, String mobile, String type)
	 {
		 String output = "";
		 try
		 {
			 Connection con = connect();
			 if (con == null)
			 {
				 return "Error while connecting to the database for updating.";
			 }
			 
			 // create a prepared statement
			 String query = "UPDATE users SET name=?,email=?,pass=?,mobile=?,type=? WHERE id=?";
			 PreparedStatement preparedStmt = con.prepareStatement(query);
	 
			 // binding values
			 preparedStmt.setString(1, name);
			 preparedStmt.setString(2, email);
			 preparedStmt.setString(3, pass);
			 preparedStmt.setString(4, mobile);
			 preparedStmt.setString(5, type); 
			 preparedStmt.setInt(6, Integer.parseInt(id)); 
	
			 // execute the statement
			 preparedStmt.execute();
			 con.close();
	
			 String newUsers = readUsers();
			 output = "{\"status\":\"success\", \"data\": \"" +
			 newUsers + "\"}";
	 }
		 
	 catch (Exception e)
	 {
		 output = "{\"status\":\"error\", \"data\": \"Error while updating the item.\"}";
		 System.err.println(e.getMessage());
	 }
	 
	return output;
}
	
	public String deleteUser(String id)
	{
		 String output = "";
		 
		 try
		 {
			 Connection con = connect();
			 if (con == null)
			 {
				 return "Error while connecting to the database for deleting.";
			 }
		 
			 // create a prepared statement
			 String query = "delete from users where id=?";
			 PreparedStatement preparedStmt = con.prepareStatement(query);
		 
			 // binding values
			 preparedStmt.setInt(1, Integer.parseInt(id));
		 
			 // execute the statement
			 preparedStmt.execute();
			 con.close();
			 String newUsers = readUsers();
			 output = "{\"status\":\"success\", \"data\": \"" +
			 newUsers + "\"}";
		 }
		 
		 catch (Exception e)
		 {
			 output = "{\"status\":\"error\", \"data\": \"Error while deleting the item.\"}";
			 System.err.println(e.getMessage());
		 }
		 
		 return output;
		 
		 }

}
