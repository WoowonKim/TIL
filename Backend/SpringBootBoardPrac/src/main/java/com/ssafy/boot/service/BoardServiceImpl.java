package com.ssafy.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.boot.model.dao.BoardDao;
import com.ssafy.boot.model.dto.Board;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public List<Board> getBoardList() {
		// TODO Auto-generated method stub
		return boardDao.selectList();
	}

	@Override
	public void insertBoard(Board board) {
		// TODO Auto-generated method stub
		boardDao.insertBoard(board);
	}

	@Override
	public Board getBoardById(int id) {
		// TODO Auto-generated method stub
		this.updateViewCnt(id);
		return boardDao.selectBoardById(id);
	}

	@Override
	public void updateViewCnt(int id) {
		// TODO Auto-generated method stub
		Board board = boardDao.selectBoardById(id);
		board.setViewCnt(board.getViewCnt()+1);
		boardDao.updateBoard(board);
	}

	@Override
	public void deleteBoard(int id) {
		// TODO Auto-generated method stub
		boardDao.deleteBoard(id);
	}

	@Override
	public void updateBoard(Board board) {
		boardDao.updateBoard(board);
	}
	
	
}
