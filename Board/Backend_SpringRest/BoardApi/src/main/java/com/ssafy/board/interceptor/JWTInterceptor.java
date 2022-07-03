package com.ssafy.board.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ssafy.board.util.JWTUtil;

@Component
public class JWTInterceptor implements HandlerInterceptor{
	private static final String HEADER_AUTH = "auth-token";
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		final String token = request.getHeader(HEADER_AUTH);
		if(token != null) {
			jwtUtil.valid(token);
			return true;
		}
		throw new Exception("토큰이 유효하지 않습니다.");
	}
}
