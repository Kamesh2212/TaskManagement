package com.userServices.repo;

import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
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
public class RegisterRepo{
	 private final JdbcTemplate jdbcTemplate;
	 
	 public  RegisterRepo(JdbcTemplate jdbcTemplate) {
	        this.jdbcTemplate = jdbcTemplate;
	    }
	 
	  public int save(RegisterAccRegisterResponse bdy,UUID uid) {
		  
		  int b =  jdbcTemplate.update("INSERT INTO userdetails(firstname,lastname ,username, email ,password ,uid) VALUES (?, ?, ?, ?, ?, ?)",
				  bdy.getFirstname(),bdy.getLastname(),bdy.getUsername(), bdy.getEmail(),bdy.getPassword(), uid);

	      return b;
	        
	    }
	  
	
}