package com.ssafy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.config.MyAppSqlConfig;
import com.ssafy.dao.EmpDAO;

@Controller
@RequestMapping("/emp")
public class EmpController {
	// 직원 리스트 
	@RequestMapping("list")
	public void list(Model model) {
		model.addAttribute("list", MyAppSqlConfig.getSession().getMapper(EmpDAO.class).selectEmp());
	}
}

