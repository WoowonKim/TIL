package com.ssafy.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.dto.Board;
import com.ssafy.board.service.BoardService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "게시물 ")
@CrossOrigin
@RestController
@RequestMapping("/api/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@ApiOperation(value = "게시글 조회",
			notes = "검색어(key)에 따른 게시물")
	@ApiImplicitParams({@ApiImplicitParam(name="key", value="검색어")})
	@GetMapping
	public ResponseEntity<List<Board>> list(@RequestParam(defaultValue = "") String key){
		return new ResponseEntity<List<Board>>(
				boardService.getBoardList(key), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Board> detail(@PathVariable int id){
		return new ResponseEntity<Board>(
				boardService.readBoardById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> write(Board board){
		boardService.writeBoard(board);
		return new ResponseEntity<String>(
				"insert 성공 " +board.toString(),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable int id){
		boardService.deleteBoard(id);
		return new ResponseEntity<String>(
				"Delete 성공 id : "+ id, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> update(Board board, @PathVariable int id){
		board.setViewCnt(boardService.readBoardById(id).getViewCnt() - 1);
		boardService.updateBoard(board);
		return new ResponseEntity<String>(
				"Update id : "+board.getId(),HttpStatus.OK);
	}
}
