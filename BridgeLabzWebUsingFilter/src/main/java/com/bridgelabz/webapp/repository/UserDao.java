package com.bridgelabz.webapp.repository;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.bridgelabz.webapp.configuration.ConnectionConfig;
import com.bridgelabz.webapp.model.UserModel;

public class UserDao {
	ConnectionConfig conn = ConnectionConfig.getInstance();
	Connection connection = conn.getDbConnection();

	public UserDao() {

	}

	public int insertUser(UserModel user) throws Exception {

		int status = 0;
		PreparedStatement myStmt = null;
		try {
			// create sql for insert
			String sql = "INSERT INTO user(user_name, name, password) VALUES (?, ?, ?)";

			myStmt = connection.prepareStatement(sql);
			// set the param values for the user
			myStmt.setString(1, user.getUsername());
			myStmt.setString(2, user.getName());
			myStmt.setString(3, user.getPassword());

			// execute sql insert
			myStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public UserModel getUser(String theUsername, String thePassword) throws Exception {

		UserModel theUser = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
			// create sql to get selected student
			String sql = "SELECT * FROM user WHERE user_name = ? AND password = ?";

			// create prepared statement
			myStmt = connection.prepareStatement(sql);
			// set params
			myStmt.setString(1, theUsername);
			myStmt.setString(2, thePassword);

			// execute statement
			myRs = myStmt.executeQuery();

			if (myRs.next()) {

				int id = myRs.getInt("id");
				String username = myRs.getString("user_name");
				String name = myRs.getString("name");
				String pass = myRs.getString("password");
				String email = myRs.getString("email");
				String state = myRs.getString("state");
				String city = myRs.getString("city");
				int age = myRs.getInt("age");

				// use the userId during construction
				theUser = new UserModel(id, username, pass, name, email, state, city, age);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return theUser;
	}

//	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
//
//		try {
//			if (myRs != null) {
//				myRs.close();
//			}
//			if (myStmt != null) {
//				myStmt.close();
//			}
//			if (myConn != null) {
//				myConn.close(); 
////doesn't really close it,just puts back in connection pool and makes it available for someone else to use
//			} 
//		} catch (Exception exc) {
//			System.out.println(exc);
//		}
//	}

	public void updateUser(UserModel theUser) throws Exception {

		PreparedStatement myStmt = null;

		try {
			// create SQL update statement
			String sql = "UPDATE user "
					+ "SET user_name = ?, name = ?, password = ?, state = ?, city = ?, email = ?, age = ? "
					+ "WHERE id = ?";

			// prepare statement
			myStmt = connection.prepareStatement(sql);

			// set params
			myStmt.setString(1, theUser.getUsername());
			myStmt.setString(2, theUser.getName());
			myStmt.setString(3, theUser.getPassword());
			myStmt.setString(4, theUser.getState());
			myStmt.setString(5, theUser.getCity());
			myStmt.setString(6, theUser.getEmail());
			myStmt.setInt(7, theUser.getAge());
			myStmt.setInt(8, theUser.getId());

			// execute SQL statement
			myStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void deleteUser(String theUserId) throws Exception {

		PreparedStatement myStmt = null;

		try {

			// convert student id to int
			int userId = Integer.parseInt(theUserId);

			// create sql to delete user
			String sql = "DELETE FROM user WHERE id = ?";

			// prepare statement
			myStmt = connection.prepareStatement(sql);

			// set params
			myStmt.setInt(1, userId);

			// execute sql statement
			myStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
