package com.kh.sc.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
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
		//System.out.println(list.size());
		
		Document doc=null;
		String selector = "span.td_t";
		try {
			doc=Jsoup.connect("https://www.naver.com").get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(doc);
		Elements titles = doc.select(selector);
		
		System.out.println(titles);
		 for(Element element: titles) { // -- 3. Elemntes 길이만큼 반복한다.
	            System.out.println(element.text()); // -- 4. 원하는 요소가 출력된다.
	        }
		model.addAttribute("list", list).addAttribute("pi", pi).addAttribute("mc", titles);
		return "board/boardList";
	}
	@RequestMapping("/board/boardInsert.do")
	public String insertBoard(Board board, Model model) {
		int result = 0;
		System.out.println(board);
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
		System.out.println(b);
		List<Comment> list = bs.selectComments(bno);
		
		
		model.addAttribute("board", b);
		
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
		
		System.out.println(loc);
		model.addAttribute("loc", loc);
		
		return "common/pageMove";
	}
	
	
}
