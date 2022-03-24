package com.ssafy.webex.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/share")
public class ShareController {
	
	//http://localhost:8080/SpringWebex/share/test01
//	@GetMapping("test01")
//	public void test01(Model model) {
//		model.addAttribute("msg", "공유데이터입니다");
//		model.addAttribute("id", "kim");
//	}
	
	@GetMapping("test01")
	public void test01(Map<String,String> model) {
		model.put("msg", "Map 공유데이터입니다");
		model.put("id", "Map kim");
	}
}
