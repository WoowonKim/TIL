package com.ssafy.board.dao;

import java.util.List;

import com.ssafy.board.dto.Board;

public interface BoardDao {
	List<Board> selectAllBoard();
	List<Board> selectBoardByQuery(String key);
	Board selectBoardById(int id);
	void insertBoard(Board board);
	void deleteBoard(int id);
	void updateBoard(Board board);
}
