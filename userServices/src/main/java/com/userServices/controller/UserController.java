package com.userServices.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userServices.api.UsersApi;
import com.userServices.service.userService;

@RestController
@RequestMapping("/users")
public class UserController implements UsersApi {

	@Autowired(required = false)
	private userService userservice;

	@DeleteMapping("/{id}")
	public ResponseEntity<String> usersIdDelete(UUID id) {

		return new ResponseEntity<String>(userservice.deleteUser(id), HttpStatus.OK);

	}

}
