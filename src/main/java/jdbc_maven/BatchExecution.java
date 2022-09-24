package jdbc_maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BatchExecution {

	public static void main(String[] args) {
		List<Person> l=new ArrayList();
		Person p=new Person(55,"him","mysore",35465,4335);
		Person p1=new Person(56,"jim","blr",48461,674);
		Person p2=new Person(57,"dee","dvg",5675,766);
		Person p3=new Person(58,"moon","dvg",4546,4657);
		l.add(p);
		l.add(p1);
		l.add(p2);
		l.add(p3);
		//jdbc code
		String path = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/jdbcprc";
		String username = "root";
		String password = "root";
		Connection con=null;
		String query="insert into person values(?,?,?,?,?)";
		try {
			Class.forName(path);
			con=DriverManager.getConnection(url,username,password);
			PreparedStatement ps=con.prepareStatement(query);
			for(Person pe:l)
			{
				ps.setInt(1, pe.getId());
				ps.setString(2,pe.getName());
				ps.setString(3, pe.getAddress());
				ps.setLong(4, pe.getPhone());
				ps.setInt(5, pe.getPin());
				ps.addBatch();
			}
			ps.executeBatch();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}

}
