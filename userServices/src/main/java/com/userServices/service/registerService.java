package com.userServices.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userServices.model.RegisterAccRegisterResponse;
import com.userServices.repo.RegisterRepo;

@Service
public class registerService {
	
	@Autowired(required = true)
	private RegisterRepo repo;
	
	public RegisterAccRegisterResponse regService(RegisterAccRegisterResponse reg) {
		
		
//		RegisterAccRegisterBody registerd = repo.save(reg);
//		if(registerd  != null) {
//			System.out.println("registered");
//	}else {
//		System.out.println("not registered");
//	}
		
		UUID uid = UUID.randomUUID();
		int response = repo.save(reg,uid);
		
		
		RegisterAccRegisterResponse r  = new RegisterAccRegisterResponse();
		
		if(response > 0) {
			r.setUid(uid);
			r.setFirstname(reg.getFirstname());
			r.setLastname(reg.getLastname());
			r.setPassword(reg.getPassword());
			r.setEmail(reg.getEmail());
			r.setUsername(reg.getUsername());
			return r;
		}
		else {
			return r;
		}
		
	
		
		
	}

}
