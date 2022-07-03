package com.ssafy.board;


import java.util.Base64;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTMain {
	public static void main(String[] args) throws Exception {
		String token = 
			Jwts.builder()
				.setHeaderParam("alg", "HS256")
				.setHeaderParam("typ", "JWT")
				.claim("userID", "ssafy")
				.setExpiration(new Date(System.currentTimeMillis() + 3000))
				.signWith(SignatureAlgorithm.HS256, "SSA".getBytes("UTF-8"))
				.compact();
		
		System.out.println(token);
		
		System.out.println(
				new String (
						Base64.getDecoder().decode(token.split("\\.")[1])
				)
				);
		
		Thread.sleep(4000);
		Jws<Claims> claims = Jwts.parser()
								.setSigningKey("SSA".getBytes("UTF-8"))
								.parseClaimsJws(token);
		System.out.println(claims);
		
		
	}

}
