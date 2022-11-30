package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import com.example.demo.model.Board;
import com.example.demo.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService service;
	
	@RequestMapping("boardform")
	public String main() {
		System.out.println("controller in");
		return "boardform";
	}
	
	@RequestMapping("boardInsert")
	public String boardInsert(Board board) {
		int result = service.boardInsert(board);
		System.out.println("result:"+result);		
		
		return "redirect:boardlist";
	}
	
	@RequestMapping("boardlist")
	public String boardlist(Model model) {
		List<Board> list = service.boardlist();
		model.addAttribute("list", list);
		
		return "boardlist";
	}	
}
