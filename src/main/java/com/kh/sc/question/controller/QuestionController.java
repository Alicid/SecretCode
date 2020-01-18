package com.kh.sc.question.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.sc.common.PageInfo;
import com.kh.sc.question.model.service.QuestionService;
import com.kh.sc.question.model.vo.Question;

@Controller
public class QuestionController {
	
	@Autowired
	QuestionService qs;
	
	@RequestMapping("/question/questionList.qo")
	public String selectquestionList(@RequestParam(value="currentPage", required=false, defaultValue="0") 
			int currentPage, Model model) {
				
		List<Question> list = new ArrayList<Question>();
		PageInfo pi = new PageInfo();
		
		if(currentPage!=0) pi.setCurrentPage(currentPage);
		
		int listCount = qs.getListCount();
		pi.calcPage(qs.getListCount());
		
		list = qs.selectList(pi);
		
		model.addAttribute("list", list).addAttribute("listCount", listCount).addAttribute("pi", pi);
		
		return "question/questionList";
		
	}
	
	@RequestMapping("/question/questionDetail.qo")
	public String selectOne(@RequestParam("qNo") int qNo, Model model) {
		
		Question q = qs.selectOne(qNo);
		System.out.println(q);
		model.addAttribute("question", q);
		
		return "question/questionDetail";
		
	}
	
	
	/*
	 * @RequestMapping("/question/qInsert.qo") public String
	 * qInsertQuestion(Question question, Model model) {
	 * 
	 * int result = 0;
	 * 
	 * result = qs.insertQuestion(question);
	 * 
	 * String msg = ""; String loc = "question/questionList";
	 * 
	 * if(result > 0) { msg = "게시글 작성 성공"; } else { msg = "게시글 작성 실패"; }
	 * 
	 * model.addAttribute("msg", msg).addAttribute("loc", loc);
	 * 
	 * return "common/msg"; }
	 */
	
//	@RequestMapping("/question/qUpdate.qo")
//	public String questionUpdate(Question question, Model model, HttpServletRequest request) {
//		
//		int qNo = question.getqNo();
//		
//		Question originQuestion = qs.selectOne(qNo);
//		originQuestion.setQuPkNo(question.getQuPkNo());
//		originQuestion.setqContent(question.getqContent());
//		
//		int result = qs.updateQuestion(originQuestion);
//		
//		String msg = "";
//		String loc = "/question/questionDetail.qo?qNo=" + qNo;
//		
//		if(result > 0) { 
//			msg = "게시글 수정 성공";
//		}else {
//			msg = "게시글 수정 실패";
//		}
//		
//		model.addAttribute("msg", msg).addAttribute("loc", loc);
//		
//		return "common/msg";
//		
//	}
//	
//	@RequestMapping("/question/qDelete.qo")
//	public String questionDelete(int qNo, Model model, HttpSession session) {
//		int result = qs.deleteQuestion(qNo);
//		
//		String msg = "";
//		String loc = "/question/questionList.qo";
//		
//		if(result > 0) {
//			msg = "게시글 삭제 성공";
//		} else {
//			msg = "게시글 삭제 실패";
//		}
//		
//		model.addAttribute("msg", msg).addAttribute("loc", loc);
//		
//		return "common/msg";
//		
//	}

}
