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
import com.kh.sc.member.model.vo.Member;
import com.kh.sc.notice.model.vo.Notice;


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
	
	@RequestMapping("/admin/adminMemberList.qo")
	public String selectadminMemberList(Model model) {
		
		List<Member> list = new ArrayList<>();
		
		
		
		list = qs.selectadminMemberList();
		System.out.println(list);
		model.addAttribute("list", list); 
		return "admin/adminMemberList"; 
	
}
	@RequestMapping("/admin/adminMemberUpdate.qo")
	public String adminMemberUpdate(@RequestParam int memberGrade,@RequestParam int uno,Model model) {
		System.out.println("회원번호 : "+uno);
		System.out.println("회원 등업시킬 번호 : "+memberGrade);
		Member m = new Member();
		m.setuNo(uno);
		m.setaNo(memberGrade);
		System.out.println(m);
		String msg = "";
		String loc = "";
		int result = qs.adminMemberUpdate(m);
		
		msg="등급변경 성공!";
		loc="/admin/adminMemberList.qo";	
		
		model.addAttribute("msg", msg);
		model.addAttribute("loc", loc);
		
		return "common/msg";
	}
}
