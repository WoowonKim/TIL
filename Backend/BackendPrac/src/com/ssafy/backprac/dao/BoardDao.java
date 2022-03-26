package com.ssafy.backprac.dao;

import java.util.List;

import com.ssafy.backprac.dto.Board;

public interface BoardDao {
	public List<Board> selectBoard();
	public void insertBoard(Board board);
	public Board selectBoardById(int no);
	public void updateViewCnt(int no);
	public void deleteBoard(int no);
	public void updateBoard(Board board);
	
}
