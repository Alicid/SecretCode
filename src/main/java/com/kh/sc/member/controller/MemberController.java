package com.kh.sc.member.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kh.sc.member.exception.MemberException;
import com.kh.sc.member.model.service.MemberService;
import com.kh.sc.member.model.vo.Member;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@RequestMapping("/memberEnrollEnd.do")
	public String memberEnrollEnd(Member member, Model model) {
		System.out.println(member);
		/********** 비밀번호 암호화 **********/
		String userPwd = member.getUserPwd();
		System.out.println("암호화 전 비밀번호 : " + userPwd);
		
		String encUserPwd = bcryptPasswordEncoder.encode(userPwd);
		System.out.println("암호화 후 비밀번호 : " + encUserPwd);
		
		member.setUserPwd(encUserPwd);
		
		/********** 비밀번호 암호화 종료 **********/
		
		int result = memberService.insertMember(member);
		
		String msg = "";
		String loc = "";
		if(result > 0) {
			msg = "회원가입을 완료했습니다.";
			loc = "/";
		} else {
			msg = "회원가입에 실패했습니다.";
			loc = "/";
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("loc", loc);
		
		return "redirect:/";
	}
	@RequestMapping("/member/memberLogin.do")
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
			
			throw new MemberException("로그인 시도 중 에러 발생!");
			
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














