package jdbc_maven;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestSaveStudent {

	public static void main(String[] args) {
		String path = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/jdbcprc";
		String username = "root";
		String password = "root";
		try {
			Class.forName(path);
			Connection con=DriverManager.getConnection(url,username,password);
			CallableStatement cs=con.prepareCall("call save_student(?,?,?,?,?)");
			cs.setInt(1, 500);
			cs.setString(2, "kol");
			cs.setLong(3, 34356);
			cs.setString(4,"blr");
			cs.setInt(5, 345);
			cs.execute();
			System.out.println("done");
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
