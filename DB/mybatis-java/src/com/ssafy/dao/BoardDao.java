package com.ssafy.dao;

import java.util.List;

import com.ssafy.dto.Board;

public interface BoardDao {
	List<Board> selectBoard();
}
