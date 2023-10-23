package src.main.java.com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	private static Connection connection;

	public static Connection getConnection() throws ClassNotFoundException, SQLException 
	{
		if( connection == null )
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp_demo", "root", "root") ;
		System.out.println("Connected");
		}
		return connection ;
	}

}
