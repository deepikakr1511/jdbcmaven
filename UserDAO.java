package com.ty.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ty.dto.User;

public class UserDAO {
	String path = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/jdbcprc";
	String username = "root";
	String password = "root";
	Connection con = null;
	public User saveDetails(User u)
	{
		String query="insert into user values(?,?,?,?,?,?,?)";
		try {
			Class.forName(path);
			con=DriverManager.getConnection(url,username,password);
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, u.getFname());
			ps.setString(2, u.getLname());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getPwd());
			ps.setLong(5, u.getPhone());
			ps.setString(6, u.getDob());
			ps.setString(7, u.getGender());
			int rows= ps.executeUpdate();
			if(rows==1)
			{
				return u;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
		}
	public User updateDetails(User u)
	{
		String query="update user set fname=?,lname=?,pwd=?,phone=?,dob=?,gender=? where email=?";
		try {
			Class.forName(path);
			con=DriverManager.getConnection(url,username,password);
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, u.getFname());
			ps.setString(2, u.getLname());
			ps.setString(7, u.getEmail());
			ps.setString(3, u.getPwd());
			ps.setLong(4, u.getPhone());
			ps.setString(5, u.getDob());
			ps.setString(6, u.getGender());
			int rows= ps.executeUpdate();
			if(rows==1)
			{
				return u;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
		}
	public String deleteDetails(String email)
	{
		String query="delete from user where email=?";
		try {
			Class.forName(path);
			con=DriverManager.getConnection(url,username,password);
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,email );
			int rows= ps.executeUpdate();
			if(rows==1)
			{
				return "deleted";
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
		}
	public User getDetails(String email,String pwd)
	{
		String query="select * from user where email=? and pwd=?";
		try {
			Class.forName(path);
			con=DriverManager.getConnection(url,username,password);
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2,pwd);
			ResultSet rs=ps.executeQuery();
			if(rs!=null)
			{
				while(rs.next())
				{
					User u=new User();
					u.setFname(rs.getString(1));
					u.setLname(rs.getString(2));
					u.setEmail(rs.getString(3));
					u.setPwd(rs.getString(4));
					u.setPhone(rs.getLong(5));
					u.setDob(rs.getString(6));
					u.setGender(rs.getString(7));
					return u;
					
				}
			}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally
		{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
		
	}
	public List<User> getAllDetails()
	{
		String query="select * from user";
		try {
			Class.forName(path);
			con=DriverManager.getConnection(url,username,password);
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			List<User> l=new ArrayList();
			if(rs!=null)
			{
				while(rs.next())
				{
					User u=new User();
					u.setFname(rs.getString(1));
					u.setLname(rs.getString(2));
					u.setEmail(rs.getString(3));
					u.setPwd(rs.getString(4));
					u.setPhone(rs.getLong(5));
					u.setDob(rs.getString(6));
					u.setGender(rs.getString(7));
					l.add(u);
					
				}
				return l;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
		
	}

}
