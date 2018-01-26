package com.maksim.service.user;

import com.maksim.model.connection.DBConnection;
import com.maksim.model.impl.UserDaoImpl;
import com.maksim.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class LoginService {

	public User validateUser(String userName, String password) {

		// defining the dao object
		UserDaoImpl dao = new UserDaoImpl();

		// getting the connection from DBUtils
		final Connection connection = DBConnection.getConnection();

		String sql_query = "SELECT USERID, FULLNAME, ADDRESS FROM USER WHERE USERNAME = ? AND PASSWORD = ?";

		User user = null;

		try {

			PreparedStatement statament = connection.prepareStatement(sql_query);

			statament.setString(1, userName);
			statament.setString(2, password);

			// executing the query
			ResultSet rs = statament.executeQuery();

			while(rs.next()) {

				// defining the UserDetails object
				user = new User();

				// setting the all attributes to object from database
				user.setUserId(rs.getInt("userId"));
				user.setUserName(userName);
				user.setFullName(rs.getString("fullName"));
				user.setAddress(rs.getString("address"));
				user.setValidUser(true);

			}

		} catch(Exception ex) {

			System.out.println(ex.getMessage());
		}

		return user;
	}
}
