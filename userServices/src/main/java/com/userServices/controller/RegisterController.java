package com.userServices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userServices.api.RegisterApi;
import com.userServices.model.RegisterAccRegisterResponse;
import com.userServices.service.registerService;

@RestController
@RequestMapping("/register")
public class RegisterController implements RegisterApi {

	@Autowired(required = false)
	private registerService reg;

	@PostMapping("/accRegister")
	public ResponseEntity<RegisterAccRegisterResponse> registerAccRegisterPost(RegisterAccRegisterResponse body) {
		
		return new ResponseEntity<RegisterAccRegisterResponse>(reg.regService(body), HttpStatus.OK);
	}

	  
//	  @PostMapping("/accRegister")
//	    public ResponseEntity<?> registerAccRegisterPost(@RequestBody RegisterAccRegisterBody body) {
//	        try {
//	            return ResponseEntity.ok(reg.regService(body));
//	        } catch (Exception e) {
//	          return exceptionHandler.handleKnownExceptions(e);
//	        
//	        }
//	    }
	  
	

}
