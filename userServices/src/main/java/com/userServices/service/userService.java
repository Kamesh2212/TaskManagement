package com.userServices.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userServices.repo.userRepo;

@Service
public class userService {
	
	@Autowired(required = true)
	private userRepo repo;
	
	public String deleteUser(UUID id) {
		int r = repo.deletebyId(id);
		
		if(r>0) {
		return "Succesfully deleted	record";
		}
		else {
			return"something went wrong while deleting";
		}
		
		
	
		
		
	}

}
