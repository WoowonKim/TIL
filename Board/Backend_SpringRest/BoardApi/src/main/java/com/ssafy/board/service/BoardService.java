package com.ssafy.board.service;

import java.util.List;

import com.ssafy.board.dto.Board;

public interface BoardService {
	List<Board> getBoardList();
	List<Board> getBoardList(String key);
	Board readBoardById(int id);
	void writeBoard(Board board);
	void deleteBoard(int id);
	void updateBoard(Board board);
	void updateViewCnt(int id);
}
