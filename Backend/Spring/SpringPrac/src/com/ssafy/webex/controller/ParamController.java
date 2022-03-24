package com.ssafy.webex.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/param")
public class ParamController {
	//http://localhost:8080/SpringWebex/param/test01?id=a&pass=1&age=22
	@GetMapping("test01")
	public String test01(HttpServletRequest request) {
		System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("pass"));
		System.out.println(request.getParameter("age"));
		return "index01";
	} //스프링스럽지 못하다
	
	@GetMapping("test02")
	public String test02(String id, String pass, Integer age) {
		System.out.println(id);
		System.out.println(pass);
		System.out.println(age);
		return "index01";
	}
	@GetMapping("test03")
	public String test03(String id, String pass, 
			@RequestParam(required = false, defaultValue = "0") int age) {
		System.out.println(id);
		System.out.println(pass);
		System.out.println(age);
		return "index01";
	}
	
	@GetMapping("test04")
	public String test04(Member m) {
		System.out.println(m.getId());
		System.out.println(m.getPass());
		System.out.println(m.getAge());
		return "index01";
	}
	
	@GetMapping("test05")
	public String test05(@RequestParam Map<String, String> map) {
		System.out.println(map.get("id"));
		System.out.println(map.get("pass"));
		System.out.println(map.get("age"));
		return "index01";
	}
}
