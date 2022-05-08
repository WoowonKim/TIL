package com.ssafy.boot.service;

import java.util.List;

import com.ssafy.boot.model.dto.Board;

public interface BoardService {
	List<Board> getBoardList();
	Board getBoardById(int id);
	void insertBoard(Board board);
	void updateBoard(Board board);
	void updateViewCnt(int id);
	void deleteBoard(int id);
}
