package jdbc_maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MobileDAO {
	String path = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/jdbcprc";
	String username = "root";
	String password = "root";
	Connection con = null;

	public String insertMobile(Mobile m) {
		String query = "insert into mobile values(?,?,?,?,?,?)";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, m.getId());
			ps.setString(2, m.getName());
			ps.setString(3, m.getBrand());
			ps.setString(4, m.getColour());
			ps.setDouble(5, m.getPrice());
			ps.setInt(6, m.getRam());
			int rows = ps.executeUpdate();
			if (rows == 1) {
				return "saved";
			}
		} catch (ClassNotFoundException e) {
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
		return "not saved";

	}

	public String updateMobile(Mobile m) {
		String query = "update mobile set name=?,brand=?,colour=?,price=?,ram=? where id=?";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, m.getName());
			ps.setString(2, m.getBrand());
			ps.setString(3, m.getColour());
			ps.setDouble(4, m.getPrice());
			ps.setInt(5, m.getRam());
			ps.setInt(6, m.getId());
			int rows = ps.executeUpdate();
			if (rows == 1) {
				return "updated";
			}
		} catch (ClassNotFoundException e) {
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
		return "not updated";

	}

	public String deleteMobile(int id) {
		String query = "delete from mobile where id=?";
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

	public Mobile getMobile(int id) {
		String query = "select * from mobile where id=?";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				Mobile m = new Mobile();
				while (rs.next()) {
					m.setId(rs.getInt(1));
					m.setName(rs.getString(2));
					m.setBrand(rs.getString(3));
					m.setColour(rs.getString(4));
					m.setPrice(rs.getDouble(5));
					m.setRam(rs.getInt(6));
					return m;
				}
			}
		} catch (ClassNotFoundException e) {
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
