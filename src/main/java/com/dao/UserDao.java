package src.main.java.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import src.main.java.com.dto.User;


public class UserDao {
	private Connection connection;
	private String query;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	public UserDao(Connection connection) {
		this.connection = connection;
	}
	
	public User userLogin(String email, String password) 
	{
		User user = null ;
		try 
		{
			query = "SELECT * From user where email=? password=?" ;
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next() )
			{
				user = new User();
				user.setId(resultSet.getInt("id"));
				user.setName(resultSet.getString("name"));
				user.setEmail(resultSet.getString("email"));
				user.setPassword(resultSet.getString("password"));
			}
		}
		catch (Exception e) 
		{
			e.getMessage();
		}
		return user ;
	}

}
