package com.ty.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ty.dto.Student;

public class StudentDAO {
	String path = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/jdbcprc";
	String username = "root";
	String password = "root";
	Connection con = null;
	public Student insertStudent(Student s)
	{
		String query="insert into student values(?,?,?,?,?)";
		try {
			Class.forName(path);
			con=DriverManager.getConnection(url,username,password);
			PreparedStatement ps=con.prepareStatement(query);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
