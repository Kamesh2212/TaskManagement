package com.userServices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userServices.model.InlineResponse200;
import com.userServices.model.LoginBody;
import com.userServices.model.RegisterAccRegisterResponse;
import com.userServices.repo.loginRepo;

@Service
public class loginService {

	@Autowired(required = true)
	private loginRepo repo;

	public String loginSer(LoginBody body) {

		RegisterAccRegisterResponse us = repo.findById(body.getUsername());

		if (us != null && body.getUsername() == us.getUsername() && body.getPassword() ==us.getPassword()) {
			
			return "Success";
		} else {

			return "failed";

		}

	}

}
