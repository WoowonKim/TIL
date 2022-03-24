package com.ssafy.webex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/request")
public class TestController {
	@RequestMapping("/test01")
	public String test01() {
		return "index01";
	}
	@RequestMapping(value="test02", method=RequestMethod.GET)
	public String test02() {
		return "index01";
	}
	@RequestMapping(path="test03", method=RequestMethod.GET)
	public String test03() {
		return "index01";
	}
	@GetMapping("test04")
	public String test04() {
		return "index01";
	}
	@PostMapping("test05")
	public String test05() {
		return "index01";
	}
	@GetMapping({"test06", "test07"})
	public String test067() {
		return "index01";
	}
}
