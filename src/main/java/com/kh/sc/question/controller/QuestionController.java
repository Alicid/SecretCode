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


@Controller
public class QuestionController {
	
	
	

	
	
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
