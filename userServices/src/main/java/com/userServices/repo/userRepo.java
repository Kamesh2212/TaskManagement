package com.userServices.repo;

import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
public class userRepo {
	private final JdbcTemplate jdbcTemplate;

	public userRepo(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int deletebyId(UUID id) {

		return jdbcTemplate.update("Delete from userdetails where uid =?", id);

	}

}