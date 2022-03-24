package com.ssafy.webex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/move")
public class MoveController {
	/*
	 * Servlet-context.xml 에 설정된 
	 * InternalResourceViewResolver - prefix, suffix 
	 * 
	 * prefix + move/test01+suffix
	 */
//	@RequestMapping("test01")
//	public String test01() {
//		return "move/test01";
//	}
	@RequestMapping("test01")
	public void test01() {
	}
//	@RequestMapping("test01")
//	public ModelAndView test01() {
//		System.out.println("ModelAndView");
//		return new ModelAndView("move/test01");
//	}
	
	/*
	 * 리다이렉트 방식은 prefix와 suffix를 붙여서 호출하지 않는다.
	 */

	public String test02() {
		return "redirect:/index.jsp";
	}
	
}
