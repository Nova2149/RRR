package AdminSide;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {
	public static void main(String[] args)
	{
		try
		{	
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/myweb419","root","host");
			Statement statement=conn.createStatement();
			ResultSet resultSet=statement.executeQuery("select * from register");
			System.out.println(resultSet);
			while(resultSet.next())
			{
				System.out.println(resultSet.getString("email"));
			}
			
		
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
