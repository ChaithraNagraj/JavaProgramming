package com.springwebmvc.repositry;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.springwebmvc.model.User;
//sql crud operation in spring (queries )
public class UserDaoImpl implements UserDao
{
	private JdbcTemplate jdbcTemplate;
	
	public UserDaoImpl(DataSource dataSource)
	{
		jdbcTemplate= new JdbcTemplate(dataSource);
	}

	public int registerUser(User user) 
	{
		String sql="INSERT INTO USER VALUES(?,?)";
		try
		{
			int counter=jdbcTemplate.update(sql, new Object[] {user.getUserId(),user.getPassword()});
			return counter;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}
		
	
	}

	public String loginUser(User user) 
	{
		String sql=" select userId from user where userId=? and password=?";
		
		try 
		{
			String userId=jdbcTemplate.queryForObject(sql,new Object[]{user.getUserId(),user.getPassword()},String.class);
			return userId;
			
		} catch (Exception e) {
			return null;
			// TODO: handle exception
		}
		
	
	}
	
	

}
