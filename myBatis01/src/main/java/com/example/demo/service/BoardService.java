package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BoardDao;
import com.example.demo.model.Board;

@Service
public class BoardService {

	@Autowired
	private BoardDao dao;
	
	public int boardInsert(Board board) {		
		return dao.boardInsert(board);
	}
	
	public List<Board> boardlist() {
		return dao.boardlist();
	}
	
}
