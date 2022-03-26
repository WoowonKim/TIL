package com.ssafy.backprac.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.backprac.config.MyAppSqlConfig;
import com.ssafy.backprac.dao.EmpDao;
import com.ssafy.backprac.dto.Emp;

@WebServlet("/main")
public class MainController extends HttpServlet{
	
	private static EmpDao empDao;
	
	public MainController() {
		empDao = MyAppSqlConfig.getSession().getMapper(EmpDao.class);
	}
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// post 요청 시 한글 파라미터의 처리를 위해 encoding을 처리한다.
		request.setCharacterEncoding("utf-8");
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String act = request.getParameter("action");
		switch (act) {
		case "login":
			dologin(request, response);
			break;
		case "logout":
			dologout(request, response);
			break;
		}
		
	}

	private void dologout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect(request.getContextPath());
	}

	private void dologin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String empno = request.getParameter("empno");
		String ename = request.getParameter("ename");
		HttpSession session = request.getSession();
		Emp emp = empDao.selectEmpById(empno, ename);
		session.setAttribute("loginEmp", emp);
		System.out.println(emp);
		response.sendRedirect(request.getContextPath());
	}
}
