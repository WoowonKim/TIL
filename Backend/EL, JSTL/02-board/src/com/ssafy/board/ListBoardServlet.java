package com.ssafy.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/list")
public class ListBoardServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// 화면에서 사용할 데이터를 구해서 
		// JSP 페이지에서 사용할 수 있도록 Request의 공유영역에 등록
		request.setAttribute("list", BoardDAO.getInstance().selectBoard());
		
		// JSP 페이지로 이동
		// http://localhost:8888/02-board/board/list.jsp
		// forward는 같은 프로젝트 내에서만 페이지 이동이 가능하므로 프로젝트경로는 제외하고 적는다.
//		RequestDispatcher rd = request.getRequestDispatcher("/board/list.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
		rd.forward(request, response);
	}
}











