package jdbc_maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {
	String path = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/jdbcprc";
	String username = "root";
	String password = "root";
	Connection con = null;

	public String savePerson(int id, String name, String address, long phone, int pin) {
		String query = "insert into person values(?,?,?,?,?)";

		try {
			// 1
			Class.forName(path);
			// 2
			con = DriverManager.getConnection(url, username, password);
			// 3
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, address);
			ps.setLong(4, phone);
			ps.setInt(5, pin);
			// 4
			int rows = ps.executeUpdate();
			if (rows == 1) {
				return "saved";
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
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

	public String savePerson1(Person p) {
		String query = "insert into person values(?,?,?,?,?)";

		try {
			// 1
			Class.forName(path);
			// 2
			con = DriverManager.getConnection(url, username, password);
			// 3
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, p.getId());
			ps.setString(2, p.getName());
			ps.setString(3, p.getAddress());
			ps.setLong(4, p.getPhone());
			ps.setInt(5, p.getPin());
			// 4
			int rows = ps.executeUpdate();
			if (rows == 1) {
				return "saved";
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
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

	public String updatePerson(int id, String name, String address, long phone, int pin) {
		String query = "update person set name=?,address=?,phone=?,pin=? where id=?";

		try {
			// 1
			Class.forName(path);
			// 2
			con = DriverManager.getConnection(url, username, password);
			// 3
			PreparedStatement ps = con.prepareStatement(query);
			// ps.setInt(1, id);
			ps.setString(1, name);
			ps.setString(2, address);
			ps.setLong(3, phone);
			ps.setInt(4, pin);
			ps.setInt(5, id);
			// 4
			int rows = ps.executeUpdate();
			System.out.println(rows);
			if (rows == 1) {
				return "updated";
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
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

	public String updatePerson1(Person p1) {
		String query = "update person set name=?,address=?,phone=?,pin=? where id=?";

		try {
			// 1
			Class.forName(path);
			// 2
			con = DriverManager.getConnection(url, username, password);
			// 3
			PreparedStatement ps = con.prepareStatement(query);
			// ps.setInt(1, id);
			ps.setString(1, p1.getName());
			ps.setString(2, p1.getAddress());
			ps.setLong(3, p1.getPhone());
			ps.setInt(4, p1.getPin());
			ps.setInt(5, p1.getId());
			// 4
			int rows = ps.executeUpdate();
			System.out.println(rows);
			if (rows == 1) {
				return "updated";
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
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

	public String DeletePerson(int id) {
		String query = "delete from person where id=?";

		try {
			// 1
			Class.forName(path);
			// 2
			con = DriverManager.getConnection(url, username, password);
			// 3
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			// 4
			int rows = ps.executeUpdate();
			System.out.println(rows);
			if (rows == 1) {
				return "deleted";
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
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

	public String getPerson(int id) {
		String query = "select * from person where id=?";

		try {
			// 1
			Class.forName(path);
			// 2
			con = DriverManager.getConnection(url, username, password);
			// 3
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getLong(4));
				System.out.println(rs.getInt(5));
				System.out.println("*****************************");
			}

			if (rs != null) {
				return "get";
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return "not get";
	}

	public Person getPerson1(int id) {
		String query = "select * from person where id=?";

		try {
			// 1
			Class.forName(path);
			// 2
			con = DriverManager.getConnection(url, username, password);
			// 3
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				Person p = new Person();
				while (rs.next()) {
					p.setId(rs.getInt(1));
					p.setName(rs.getString(2));
					p.setAddress(rs.getString(3));
					p.setPhone(rs.getLong(4));
					p.setPin(rs.getInt(5));
					return p;
				}

			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
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
