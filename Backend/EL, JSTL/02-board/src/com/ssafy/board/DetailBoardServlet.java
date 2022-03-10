package com.ssafy.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/detail")
public class DetailBoardServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException{
		int no =  Integer.parseInt(req.getParameter("no"));
		Board board = BoardDAO.getInstance().selectBoard().get(no-1);
		board.setViewCnt(board.getViewCnt()+1);
		req.setAttribute("detail", board);
		req.getRequestDispatcher("detail.jsp").forward(req, res);
	}
}
