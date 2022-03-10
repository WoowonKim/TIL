package com.ssafy.board;

import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
	private List<Board> list = new ArrayList<>();
	private int no = 0;
	private static BoardDAO instance;
	private BoardDAO() {		
		insertBoard(new Board("10분 뒤에 쉬겠습니다", "쌤", "5시 5분까지 쉬겠습니다"));
		insertBoard(new Board("10분 뒤에 쉼", "쌤", "5시 5분까지 쉬겠습니다"));
		insertBoard(new Board("10분 뒤에 쉬겠슴", "쌤", "5시 5분까지 쉬겠습니다"));
		insertBoard(new Board("10분 뒤에 쉬겠슴돠", "쌤", "5시 5분까지 쉬겠습니다"));
	}
	public static BoardDAO getInstance() {
		if (instance == null) instance = new BoardDAO();
		return instance;
	}
	public List<Board> selectBoard() {
		return list;
	}
	public void insertBoard(Board board) {
		board.setNo(++no);
		list.add(board);
	}
}










