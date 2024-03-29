package com.nagyeong.realEstate.repository.implement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.nagyeong.realEstate.repository.UserRepository;

public class UserRepositoryImplement implements UserRepository {
	private Connection connection;
	
	public UserRepositoryImplement () {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			final String URL = "jdbc:mysql://127.0.0.1:3306/real_estate";
			final String USER_NAME = "root";
			final String USERPASSWORD = "root";
			this.connection = DriverManager.getConnection(URL, USER_NAME, USERPASSWORD);
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
	}

	@Override
	public boolean existsById(String id) throws SQLException {
		boolean result = false;
		
		final String SQL = "SELECT * FROM user WHERE user_id = ?";
		
		PreparedStatement preparedStatement = connection.prepareStatement(SQL);
		preparedStatement.setString(1, id);
			
		ResultSet resultSet = preparedStatement.executeQuery();
		result = resultSet.next();
		
		return result;
	}

}
