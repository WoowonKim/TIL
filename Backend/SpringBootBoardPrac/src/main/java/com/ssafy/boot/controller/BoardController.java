package com.ssafy.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.boot.model.dto.Board;
import com.ssafy.boot.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService boardService;

	@GetMapping("/list")
	public String list(Model model) {
		List<Board> list = boardService.getBoardList();
		model.addAttribute("list", list);
		return "board/list";
	}

	@GetMapping("/writeForm")
	public String writeForm() {
		return "board/writeform";
	}

	@PostMapping("write")
	public String write(String title, String writer, String content) {
		Board board = new Board();
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		boardService.insertBoard(board);
		return "redirect:/board/list";
	}
	
	@GetMapping("detail")
	public String detail(int id, Model model) {
		Board board = boardService.getBoardById(id);
		model.addAttribute("board", board);
		return "board/detail";
	}
	
	@GetMapping("delete")
	public String delete(int id) {
		boardService.deleteBoard(id);
		return "redirect:/board/list";
	}
	
	@GetMapping("updateForm")
	public String updateForm(int id, Model model) {
		Board board = boardService.getBoardById(id);
		model.addAttribute("board", board);
		return "board/updateform";
	}
	
	@PostMapping("update")
	public String update(Board board) {
		boardService.updateBoard(board);
		return "redirect:/board/list";
	}
}
