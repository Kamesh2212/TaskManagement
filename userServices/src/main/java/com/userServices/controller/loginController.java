package com.userServices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userServices.api.LoginApi;
import com.userServices.model.LoginBody;
import com.userServices.service.loginService;

@RestController
//@RequestMapping("/login")
public class loginController implements LoginApi {

	@Autowired(required = false)
	private loginService log;

	@Override
	@RequestMapping("/login")
	public ResponseEntity<String> loginPost(LoginBody body) {

		return new ResponseEntity<String>(log.loginSer(body), HttpStatus.OK);
	}

}
