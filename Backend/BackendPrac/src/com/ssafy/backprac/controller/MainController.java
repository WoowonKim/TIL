package com.ssafy.backprac.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.backprac.config.MyAppSqlConfig;
import com.ssafy.backprac.dao.BoardDao;
import com.ssafy.backprac.dao.EmpDao;
import com.ssafy.backprac.dto.Board;
import com.ssafy.backprac.dto.Emp;

@WebServlet("/main")
public class MainController extends HttpServlet {

	private static EmpDao empDao;
	private static BoardDao boardDao;

	public MainController() {
		empDao = MyAppSqlConfig.getSession().getMapper(EmpDao.class);
		boardDao = MyAppSqlConfig.getSession().getMapper(BoardDao.class);
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

	private void process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String act = request.getParameter("action");
		switch (act) {
		case "login":
			dologin(request, response);
			break;
		case "logout":
			dologout(request, response);
			break;
		case "emplist":
			doemplist(request, response);
			break;
		case "board":
			doboard(request, response);
			break;
		case "writeboard":
			dowriteboard(request, response);
			break;
		case "detail":
			dodetail(request, response);
			break;
		case "del":
			dodel(request, response);
			break;
		case "update":
			doupdate(request, response);
			break;
		case "updateboard":
			doupdateboard(request, response);
			break;
		}
		
	}

	private void doupdateboard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int no = Integer.parseInt(request.getParameter("no"));
		Board board = boardDao.selectBoardById(no);
		board.setContent(request.getParameter("content"));
		board.setTitle(request.getParameter("title"));
		boardDao.updateBoard(board);
		response.sendRedirect("main?action=board");
	}

	private void doupdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		Board board = boardDao.selectBoardById(no);
		request.setAttribute("board", board);
		request.getRequestDispatcher("board/updateform.jsp").forward(request, response);
//		board.setContent(request.getParameter("content"));
//		board.setTitle(request.getParameter("title"));
	}

	private void dodel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		boardDao.deleteBoard(no);
		response.sendRedirect("main?action=board");
	}

	private void dodetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		request.setAttribute("board", boardDao.selectBoardById(no));
		boardDao.updateViewCnt(no);
		request.getRequestDispatcher("board/detail.jsp").forward(request, response);
	}

	private void dowriteboard(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		Board board = new Board(title, writer, content);
		boardDao.insertBoard(board);
		response.sendRedirect("main?action=board");
	}

	private void doboard(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("list", boardDao.selectBoard());
		request.getRequestDispatcher("board/list.jsp").forward(request, response);
	}

	private void doemplist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Emp> list = empDao.selectEmp();
		request.setAttribute("list", list);
		request.getRequestDispatcher("emp/list.jsp").forward(request, response);
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
		response.sendRedirect(request.getContextPath());
	}
}
