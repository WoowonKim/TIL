package com.ssafy.board.util;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {
	private static final String SALT = "SSAFIT";
	public String createToken(String clamimId, String data) throws Exception{
		return Jwts.builder()
				.setHeaderParam("alg", "HS256")
				.setHeaderParam("typ", "JWT")
				.claim(clamimId, data)
				.signWith(SignatureAlgorithm.HS256, SALT.getBytes("UTF-8"))
				.compact();
	}
	public void valid(String token) throws Exception{
		Jwts.parser()
		.setSigningKey(SALT.getBytes("UTF-8"))
		.parseClaimsJws(token);
	}
}
