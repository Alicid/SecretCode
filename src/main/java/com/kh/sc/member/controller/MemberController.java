package com.kh.sc.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.sc.member.exception.MemberExcrption;
import com.kh.sc.member.model.service.MemberService;
import com.kh.sc.member.model.vo.Member;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@RequestMapping("memberLogin.do")
	public ModelAndView memberLogin(Member member, HttpSession session) {
		ModelAndView mv = new ModelAndView();
			System.out.println("화면 전달 확인 : "+member);
		try {
			Member m = memberService.selectOneMember(member);
			
			String msg = "";
			String loc = "/";
			System.out.println("로그인 확인 : " + m);
			
			if(m != null && bcryptPasswordEncoder.matches(member.getUserPwd(), m.getUserPwd())) {
				msg = "로그인 성공!";
				session.setAttribute("member", m);
				mv.addObject("member", m);
				
			} else if(m != null) {
				msg = "비밀번호가 틀렸습니다.";
				
			} else { 
				msg = "로그인 실패!";
			}
			mv.addObject("msg", msg).addObject("loc", loc);
			mv.setViewName("common/msg");
			
		} catch(Exception e) {
			
			throw new MemberExcrption("로그인 시도 중 에러 발생!");
			
		}
		return mv;
	}
	
	@RequestMapping("/member/memberView.do")
	public String memberView(@RequestParam String userId, Model model) {
		Member member = memberService.memberView(userId);
		
		model.addAttribute("member", member);
		
		return "member/memberView";
	}
	
	

}














