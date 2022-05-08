package com.ssafy.boot.model.dao;

import java.util.List;

import com.ssafy.boot.model.dto.Board;

public interface BoardDao {
	List<Board> selectList();
	Board selectBoardById(int id);
	void insertBoard(Board board);
	void updateBoard(Board board);
	void deleteBoard(int id);
}
