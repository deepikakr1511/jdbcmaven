package jdbc_maven;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TestRetrieveStudent1 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String path = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/jdbcprc";
		String username = "root";
		String password = "root";
		try {
			Class.forName(path);
			Connection con=DriverManager.getConnection(url,username,password);
			CallableStatement cs=con.prepareCall("call get_stu(?)");
			/*System.out.println("enter the id to retrieve: ");
			int id=s.nextInt();*/
			cs.setInt(1, 100);
			ResultSet rs=cs.executeQuery();
			
			while(rs.next())
			{
				
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getLong(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getInt(5));
				
			}
			
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
