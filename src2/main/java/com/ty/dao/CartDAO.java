package com.ty.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ty.dto.Cart;

public class CartDAO {
	String path = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/jdbcprc";
	String username = "root";
	String password = "root";
	Connection con = null;

	public Cart saveCart(Cart c) {
		String query = "insert into cart values(?,?,?,?,?)";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, c.getId());
			ps.setString(2, c.getEmail());
			ps.setString(3, c.getPassword());
			ps.setString(4, c.getUsername());
			ps.setString(5, c.getAddress());
			int rows = ps.executeUpdate();
			if (rows == 1) {
				return c;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public Cart updateCart(Cart c) {
		String query = "update cart set email=?,password=?,username=?,address=? where id=?";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(5, c.getId());
			ps.setString(1, c.getEmail());
			ps.setString(2, c.getPassword());
			ps.setString(3, c.getUsername());
			ps.setString(4, c.getAddress());
			int rows = ps.executeUpdate();
			if (rows == 1) {
				return c;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	public String deleteCart(int id) {
		String query = "delete from cart where id=?";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			int rows = ps.executeUpdate();
			if (rows == 1) {
				return "deleted";
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "not deleted";
	}
	public Cart getCart(int id) {
		String query = "select * from cart where id=?";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			if(rs!=null)
			{
				Cart c=new Cart();
				while(rs.next())
				{
					c.setId(rs.getInt(1));
					c.setEmail(rs.getString(2));
					c.setPassword(rs.getString(3));
					c.setUsername(rs.getString(4));
					c.setAddress(rs.getString(5));
					return c;
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	public List<Cart> getAllCart() {
		String query = "select * from cart";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			List<Cart> l=new ArrayList();
		
				
				while(rs.next())
				{
					Cart c=new Cart();
					c.setId(rs.getInt(1));
					c.setEmail(rs.getString(2));
					c.setPassword(rs.getString(3));
					c.setUsername(rs.getString(4));
					c.setAddress(rs.getString(5));
					l.add(c);
				}
				return l;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

}

	