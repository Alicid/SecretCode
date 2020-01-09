package com.kh.sc.question.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.sc.common.PageInfo;
import com.kh.sc.question.model.service.QusetionService;
import com.kh.sc.question.model.vo.Question;

@Controller
public class QuestionController {

	@Autowired
	QusetionService qs;
	
	@Autowired
	PageInfo pi;
	
	@RequestMapping("/question/questionList.do")
	public String questionList(
			@RequestParam(value="currentPage",
			required=false,
			defaultValue="1") int currentPage,
			Model model) {
		List<Question> list = new ArrayList<Question>();
		
		pi.calcPage(qs.get);
		
		return null;
			
	}
			
	
	
}
