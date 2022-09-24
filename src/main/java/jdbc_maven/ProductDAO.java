package jdbc_maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
	String path = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/jdbcprc";
	String username = "root";
	String password = "root";
	Connection con = null;

	public Product insertProduct(Product p) {
		String query = "insert into product values(?,?,?,?,?,?,?,?)";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, p.getPid());
			ps.setString(2, p.getPname());
			ps.setDouble(3, p.getPrice());
			ps.setString(4, p.getManufacturer());
			ps.setDouble(5, p.getDiscount());
			ps.setInt(6, p.getWarrenty());
			ps.setString(7, p.getMfgdate());
			ps.setDouble(8, p.getGst());
			int rows = ps.executeUpdate();
			if (rows == 1) {
				return p;
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

	public Product updateProduct(Product p) {
		String query = "update product set pname=?,price=?,manufacturer=?,discount=?,warrenty=?,mfgdate=?,gst=? where pid=?";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(8, p.getPid());
			ps.setString(1, p.getPname());
			ps.setDouble(2, p.getPrice());
			ps.setString(3, p.getManufacturer());
			ps.setDouble(4, p.getDiscount());
			ps.setInt(5, p.getWarrenty());
			ps.setString(6, p.getMfgdate());
			ps.setDouble(7, p.getGst());
			int rows = ps.executeUpdate();
			if (rows == 1) {
				return p;
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

	public String deleteProduct(int pid) {
		String query = "delete from product where pid=?";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, pid);
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

	public Product getProduct(int id) {
		String query = "select * from product where pid=?";
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				Product p = new Product();
				while (rs.next()) {
					p.setPid(rs.getInt(1));
					p.setPname(rs.getString(2));
					p.setPrice(rs.getDouble(3));
					p.setManufacturer(rs.getString(4));
					p.setDiscount(rs.getDouble(5));
					p.setWarrenty(rs.getInt(6));
					p.setMfgdate(rs.getString(7));
					p.setGst(rs.getDouble(8));
					return p;
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
	public List<Product> getAllProduct()
	{
		String query="select * from product";
		try {
			Class.forName(path);
			con=DriverManager.getConnection(url,username,password);
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			List<Product> l=new ArrayList();
			while(rs.next())
			{
				Product p=new Product();
				p.setPid(rs.getInt(1));
				p.setPname(rs.getString(2));
				p.setPrice(rs.getDouble(3));
				p.setManufacturer(rs.getString(4));
				p.setDiscount(rs.getDouble(5));
				p.setWarrenty(rs.getInt(6));
				p.setMfgdate(rs.getString(7));
				p.setGst(rs.getInt(8));
				l.add(p);
				
			}
			return l;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}
