package com.userServices.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.userServices.model.RegisterAccRegisterResponse;


//public interface RegisterRepo extends JpaRepository<RegisterAccRegisterBody,Integer> {
//
//
//	
//	RegisterAccRegisterBody save(RegisterAccRegisterBody bdy);
//
//	
//
//}

@Repository
public class loginRepo {
	private final JdbcTemplate jdbcTemplate;

	public loginRepo(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

//	 @SuppressWarnings("deprecation")
//	public User findByUsername(String username) {
//	        String sql = "SELECT * FROM userdetails WHERE username = ?";
//	        try {
//	            return jdbcTemplate.query(sql, new Object[]{username}, rs -> {
//	                if (rs.next()) {
//	                    User user = new User();
//	                    user.setId(rs.getString("id"));
//	                    user.setUsername(rs.getString("username"));
//	 //                   user.setPassword(rs.getString("password"));
//	                    return user;
//	                }
//	                return null;
//	            });
//	        } catch (Exception e) {
//	            return null;
//	        }
//	    }
	 
	 @SuppressWarnings("deprecation")
	public RegisterAccRegisterResponse findById(String username) {
	        try {
	            return jdbcTemplate.queryForObject(
	                "SELECT * FROM userdetails WHERE username = ?", 
	                new Object[]{username}, 
	                new UserRowMapper()
	            );
	        } catch (Exception e) {
	            // Handle the exception or log it
	            throw new RuntimeException("Error fetching user with ID: " + username, e);
	        }
	    }

	    private static class UserRowMapper implements RowMapper<RegisterAccRegisterResponse> {
	        public RegisterAccRegisterResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	RegisterAccRegisterResponse user = new RegisterAccRegisterResponse();
	            user.uid((UUID) rs.getObject("uid"));
	            user.username(rs.getString("username"));
	            user.firstname(rs.getString("firstname"));
	            user.lastname(rs.getString("lastname"));
	            user.email(rs.getString("email"));
	            user.password(rs.getString("password"));
	            // Map other columns as necessary
	            return user;
	        }
	    }
	}
