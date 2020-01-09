package com.kh.sc.board.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.sc.board.model.service.BoardService;
import com.kh.sc.board.model.vo.Board;
import com.kh.sc.board.model.vo.Comment;
import com.kh.sc.common.PageInfo;

@Controller
public class BoardController {

	@Autowired
	BoardService bs;
	
	@Autowired
	PageInfo pi;
	
	@RequestMapping("/board/boardSelectList.do")
	public String selectBoardList(
			@RequestParam(value="currentPage",
			required=false,
			defaultValue="1") int currentPage,
			Model model) {
		List<Board> list = new ArrayList<Board>();
		
		pi.calcPage(bs.getListCount());
		System.out.println("총 게시글 수 : "+bs.getListCount());
		System.out.println("페이지 처리 확인 : " + pi);
		
		list = bs.selectList(pi);
	
		model.addAttribute("list", list);
		return "board/boardList";
	}
	@RequestMapping("/board/boardInsert.do")
	public String insertBoard() {
	
		
		return "board/boardList";
	}
	
	@RequestMapping("/board/boardInsertView.do")
	public String insertBoardView() {
		
		
		return "board/boardInsertForm";
	}
	
	@RequestMapping("/board/boardDetail.do")
	public String boardDetail() {
		
		return "board/boardDetail";
	}
	@RequestMapping("/board/selectOne.do")
	public String selectOne(@RequestParam("bno") int bno, Model model) {
	
		Board b = bs.selectOne(bno);
		System.out.println(b);
		List<Comment> list = bs.selectComments(bno);
		
		
		model.addAttribute("board", b);
		
		return "board/boardDetail";
	}
	
	/*---------------------------------------------------------------------------------*/
	@RequestMapping("/comment/insertComment.do")
	public String insertComment(Comment cmt,Model model) {
		System.out.println(cmt);
		
		int result = bs.insertComment(cmt);
		
		String loc = "/board/selectOne.do?bno="+cmt.getBno();
		
		System.out.println(loc);
		model.addAttribute("loc", loc);
		
		return "common/pageMove";
	}
	
	
}
