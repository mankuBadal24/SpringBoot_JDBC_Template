package com.example.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository
public class UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemp;
	
//	=========== Insertion =================
	public boolean insertUser(User user) {
		boolean status = false;
		try {
			String insert_sql_query = "insert into users(name,email,gender,city) values(?,?,?,?)";
			int count = jdbcTemp.update(insert_sql_query,user.getName(),user.getEmail(),user.getGender(),user.getCity());
			if(count>0) {
				status = true;
			}else {
				status=false;
			}
		}catch (Exception e) {
			status = false;
			e.printStackTrace();
		}
		return status;
	}
	
//	============= Updation ===================
	public boolean updateUser(User user) {
		boolean status = false;
		try {
			String update_sql_query = "update users set name=?,gender=?,city=? where email=?";
//			sequence of user,get methods is same as queryyyyy
			int count = jdbcTemp.update(update_sql_query,user.getName(),user.getGender(),user.getCity(),user.getEmail());
			if(count>0) {
				status = true;
			}else {
				status = false;
			}
		}catch (Exception e) {
			status = false;
			e.printStackTrace();
		}
		return status;
	}
	
	public boolean deleteUserByEmail(String email) {
		boolean status = false;
		try {
			String delete_sql_query = "delete from users where email=?";
			int count = jdbcTemp.update(delete_sql_query,email);
			if(count>0) {
				status = true;
			}else {
				status = false;
			}
		}catch (Exception e) {
			status = false;
			e.printStackTrace();
		}
		return status;
	}
	
	public User getUserByEmail(String email) {
		String select_query_sql = "select * from users where email=?";
		return jdbcTemp.queryForObject(select_query_sql,new UserRowMapper(), email );
	}
	
	public static final class UserRowMapper implements RowMapper<User> {
		@Override
		public User mapRow(ResultSet rs,int rowNum) throws SQLException{
			User user = new User();
			user.setName(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			user.setGender(rs.getString("gender"));
			user.setCity(rs.getString("city"));
			
			return user;
		}
	}
	
	
	public List<User> getAllUsers(){
		String select_all_user_query = "select * from users";
		return jdbcTemp.query(select_all_user_query,new UserRowMapper());
	}
}
