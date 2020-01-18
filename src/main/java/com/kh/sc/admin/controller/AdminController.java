package com.kh.sc.admin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.sc.admin.model.service.AdminService;
import com.kh.sc.admin.model.vo.Question;
import com.kh.sc.common.PageInfo;


@Controller
public class AdminController {
	
	@Autowired
	AdminService qs;
	
	@RequestMapping("/admin/adminQuestion.do")
	public String adminQuestion() {
		
		return "admin/adminQuestion";
	}
	
	@RequestMapping("/admin/questionInsert.do")
	public String questionInsert() {
		
		return "admin/adminQuestion";
	}
	
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
		
		return "admin/questionList";
		
	}
	
	@RequestMapping("/question/questionDetail.qo")
	public String selectOne(@RequestParam("qNo") int qNo, Model model) {
		
		Question q = qs.selectOne(qNo);
		System.out.println(q);
		model.addAttribute("question", q);
		
		return "admin/questionDetail";
		
	}
}
