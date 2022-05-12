package com.ssafy.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.board.dao.BoardDao;
import com.ssafy.board.dto.Board;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDao boardDao;
	
	@Override
	public List<Board> getBoardList() {
		// TODO Auto-generated method stub
		return boardDao.selectAllBoard();
	}
	
	@Override
	public List<Board> getBoardList(String key) {
		// TODO Auto-generated method stub
		return boardDao.selectBoardByQuery(key);
	}

	@Override
	public Board readBoardById(int id) {
		// TODO Auto-generated method stub
		updateViewCnt(id);
		return boardDao.selectBoardById(id);
	}

	@Override
	public void writeBoard(Board board) {
		// TODO Auto-generated method stub
		boardDao.insertBoard(board);
	}

	@Override
	public void deleteBoard(int id) {
		// TODO Auto-generated method stub
		boardDao.deleteBoard(id);
	}


	@Override
	public void updateBoard(Board board) {
		// TODO Auto-generated method stub
		boardDao.updateBoard(board);
	}

	@Override
	public void updateViewCnt(int id) {
		// TODO Auto-generated method stub
		Board board = boardDao.selectBoardById(id);
		board.setViewCnt(board.getViewCnt()+1);
		boardDao.updateBoard(board);
	}
	
}
