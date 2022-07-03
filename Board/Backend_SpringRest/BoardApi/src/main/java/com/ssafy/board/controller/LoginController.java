package com.ssafy.board.controller;

import java.util.HashMap;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


import com.ssafy.board.dto.User;

import com.ssafy.board.util.JWTUtil;


@RestController
@RequestMapping("/api")
public class LoginController {
	
	@Autowired
	private JWTUtil jwtutil;
	
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(@RequestBody User user){
		HttpStatus status = null;
		HashMap<String, Object> result = new HashMap<String, Object>();
		try {
			if(user.getId() != null || user.getId().length() > 0) {
			result.put("auth-token", jwtutil.createToken("userID", user.getId()));
			result.put("message", "success");
			status = HttpStatus.ACCEPTED;
			} else {
				result.put("message", "Fail");
				status = HttpStatus.ACCEPTED;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String,Object>>(result, status);
	}
	
}
