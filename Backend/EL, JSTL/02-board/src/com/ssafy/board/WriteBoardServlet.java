package com.ssafy.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/write")
public class WriteBoardServlet extends HttpServlet {
	// 글쓰기 폼 이동
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// write.jsp 페이지로 이동하기
		request.getRequestDispatcher("write.jsp").forward(request, response);
	}
	
	// 글등록 처리
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// 파라미터 한글 인코딩 처리하기
		request.setCharacterEncoding("utf-8");
		
		// 파라미터 꺼내기
		BoardDAO.getInstance().insertBoard(new Board(
				request.getParameter("title"), 
				request.getParameter("writer"), 
				request.getParameter("content")
		));
		
		// 페이지 이동하기
		// 다른 프로젝트 또는 다른 사이트로 이동이 가능하다.
		// 프로젝트의 페이지를 호출시 "/"로 시작할 경우 프로젝트 경로를 적어야 한다.
		response.sendRedirect("list");
//		response.sendRedirect("/02-board/board/list");
		
		// 2가지 문제 발생 : 
		// 1. list 서블릿이 get방식에서 post 방식의 처리도 가능하게 하기 위해 service 로 변경해야 했다.
		// 2. url이 목록을 보여주고 있음에도 write로 되어 있기 때문에 새로고침시 글이 다시 등록되는 현상 발생
//		request.getRequestDispatcher("list").forward(request, response);
	}
	
}







