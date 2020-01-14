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
	
	
	@RequestMapping("/board/boardSelectList.do")
	public String selectBoardList(
			@RequestParam(value="currentPage",
			required=false,
			defaultValue="0") int currentPage,
			Model model) {
		List<Board> list = new ArrayList<Board>();
		
		PageInfo pi = new PageInfo();
		if(currentPage !=0)pi.setCurrentPage(currentPage);
		
		pi.calcPage(bs.getListCount());
		System.out.println("총 게시글 수 : "+bs.getListCount());
		System.out.println("페이지 처리 확인 : " + pi);
		
		list = bs.selectList(pi);
		//System.out.println(list);
	
		
		model.addAttribute("list", list).addAttribute("pi", pi);
		return "board/boardList";
	}
	@RequestMapping("/board/boardInsert.do")
	public String insertBoard(Board board,@RequestParam int uNo, Model model) {
		int result = 0;
		System.out.println(board);
		System.out.println(uNo);
		board.setUno(uNo);
		result = bs.insertBoard(board);
		
		String msg = "";
		String loc = "/board/boardSelectList.do";

		if (result > 0) {
			msg = "게시글 작성 성공";
		} else {
			msg = " 게시글 작성 실패";
		}

		model.addAttribute("msg", msg).addAttribute("loc", loc);

		return "common/msg";
	}
	
	@RequestMapping("/board/boardInsertView.do")
	public String insertBoardView() {
		
		return "board/boardInsertForm";
	}
	
	
	@RequestMapping("/board/selectOne.do")
	public String selectOne(@RequestParam("bno") int bno, Model model) {
	
		Board b = bs.selectOne(bno);
		//System.out.println(b);
		List<Comment> list = bs.selectComments(bno);
		//System.out.println(list);
		//System.out.println("댓글 갯수"+list.size());
		model.addAttribute("board", b).addAttribute("clist", list);
		
		return "board/boardDetail";
	}
	
	@RequestMapping("/board/bUpdateForm.do")
	public String bUpdateForm(@RequestParam int bno, Model model) {
		System.out.println(bno);
		model.addAttribute("board", bs.selectOne(bno));
		return "board/boardUpdateForm";
	}
	
	@RequestMapping("/board/bUpdate.do")
	public String boardUpdate(Board board, Model model) {
		System.out.println(board);
		int result = bs.updateBoard(board);
		int bno = board.getBno();
		String msg = "";
		String loc = "/board/selectOne.do?bno=" + bno;

		if (result > 0) {
			msg = "게시글 수정 성공";
		} else {
			msg = " 게시글 수정 실패";
		}

		model.addAttribute("msg", msg).addAttribute("loc", loc);

		return "common/msg";
	}
	
	@RequestMapping("/board/boardDelete.do")
	public String boardDelete(@RequestParam int bno,Model model) {
		int result = bs.deleteBoard(bno);
		
		String msg = "";
		String loc = "/board/boardSelectList.do";

		if (result > 0) {
			msg = "게시글 삭제 성공!";

		} else {
			msg = "게시글 삭제 실패";
		}

		model.addAttribute("msg", msg).addAttribute("loc", loc);
		
		return "common/msg";
	}
	
	/*--------------------------------------댓글 관련 메소드-------------------------------------------*/
	@RequestMapping("/comment/insertComment.do")
	public String insertComment(Comment cmt,Model model) {
		System.out.println(cmt);
		
		int result = bs.insertComment(cmt);
		
		String loc = "/board/selectOne.do?bno="+cmt.getBno();
		
		//System.out.println(loc);
		model.addAttribute("loc", loc);
		
		return "common/pageMove";
	}
	
	@RequestMapping("/comment/updateComment.do")
	public String updateComment(Comment cmt,Model model) {
		System.out.println(cmt);
		
		int result = bs.updateComment(cmt);
		
		String loc = "/board/selectOne.do?bno="+cmt.getBno();
		
		model.addAttribute("loc", loc);
		
		return "common/pageMove";
	}
	
	@RequestMapping("/comment/deleteComment.do")
	public String deleteComment(@RequestParam int cno,@RequestParam int bno,Model model) {
		System.out.println("일반 삭제");
		System.out.println("cno :"+cno);
		System.out.println("bno :"+bno);
		
		int result = bs.deleteComment(cno);
				
		String loc = "/board/selectOne.do?bno="+bno;
		
		model.addAttribute("loc", loc);
		
		return "common/pageMove";
	}

	@RequestMapping("/comment/deleteCommentbyAdmin.do")
	public String deleteCommentbyAdmin(@RequestParam int cno,@RequestParam int bno,Model model) {
		System.out.println("관리자 삭제");
		System.out.println("cno :"+cno);
		System.out.println("bno :"+bno);
	
		int result = bs.deleteCommentbyAdmin(cno);
				
		String loc = "/board/selectOne.do?bno="+bno;
		
		model.addAttribute("loc", loc);
		
		return "common/pageMove";
	}
	
	
}
