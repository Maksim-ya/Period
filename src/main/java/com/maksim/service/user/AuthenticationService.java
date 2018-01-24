package com.maksim.service.user;

import com.maksim.model.connection.DBConnection;
import com.maksim.model.impl.UserDaoImpl;
import com.maksim.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class AuthenticationService {

	public User validateUser(String userName, String password) {

		// defining the dao object
		UserDaoImpl dao = new UserDaoImpl();

		// getting the connection from DBUtils
		final Connection connection = DBConnection.getConnection();

		String sql_query = "SELECT USERID, USERNAME, ADDRESS FROM USER WHERE USERNAME = ? AND PASSWORD = ?";

		User user = null;

		try {

			PreparedStatement stmt = connection.prepareStatement(sql_query);

			stmt.setString(1, userName);
			stmt.setString(2, password);

			// executing the query
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {

				// defining the UserDetails object
				user = new User();

				// setting the all attributes to object from database
				user.setUserId(rs.getInt("userId"));
				user.setUserName(userName);
				user.setName(rs.getString("userName"));
				user.setAddress(rs.getString("address"));
				user.setValidUser(true);

			}

		} catch(Exception ex) {

			System.out.println(ex.getMessage());
		}

		return user;
	}
}
