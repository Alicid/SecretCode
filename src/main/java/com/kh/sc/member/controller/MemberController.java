package com.kh.sc.member.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

import com.kh.sc.member.email.RandomNumber;
import com.kh.sc.member.email.model.service.EmailService;
import com.kh.sc.member.exception.MemberException;
import com.kh.sc.member.model.service.MemberService;
import com.kh.sc.member.model.vo.Member;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@Autowired
	EmailService emailService;
	
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
		
		return "member/mypage";
	}
	
	@RequestMapping("/member/memberLogout.do")
	public String memberLogout(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/";
	}
	@RequestMapping("member/memberUpdate.do")
	public String memberUpdate(Member member, Model model, HttpSession session) {
		
		if(member.getUserPwd().length() > 0) {
			System.out.println("암호화 전 변경한 비밀번호 : " + member.getUserPwd());
			String encUserPwd = bcryptPasswordEncoder.encode(member.getUserPwd());
			member.setUserPwd(encUserPwd);
			System.out.println("암호화 후 비밀번호 : " + encUserPwd);
		} else {
			member.setUserPwd(null);
		}
		System.out.println(member);
		int result = memberService.updateMember(member);
		
		String msg = "";
		String loc = "";
		
		if(result > 0) {
			msg = "수정 완료";
			loc="/";
			session.setAttribute("member", member);
		} else {
			msg = "수정 실패";
			loc = "/";
		}
		model.addAttribute("msg", msg).addAttribute("loc", loc);
		
		System.out.println(result);
		return "common/msg";
	}
	@RequestMapping("/member/mypageDelete.do")
	public String memberDelete(@RequestParam String userPwd, HttpSession session,Model model) {
		
		Member m = (Member)session.getAttribute("member");
		int result = memberService.deleteMember(m.getUserId());
		
		String msg = "";
		String loc = "/";
		
		if(m != null && bcryptPasswordEncoder.matches(userPwd, m.getUserPwd())) {
			msg="탈퇴 완료";
			loc="/";
			session.invalidate();
		} else {
			msg="비밀번호가 틀렸습니다!";
			loc="/member/mypageDeleteView.do";
		}
		
		model.addAttribute("msg", msg).addAttribute("loc", loc);
		
		return "common/msg";
	}
	
	@RequestMapping("/member/mypageUpdate.do")
	public String memberUpdate_confirm(@RequestParam String userPwd, HttpSession session,Model model) {
		System.out.println(userPwd);
		Member m = (Member) session.getAttribute("member");
		System.out.println(m);
		String msg = "";
		String loc = "/";
		if(m != null && bcryptPasswordEncoder.matches(userPwd, m.getUserPwd())) {
			msg="내 정보 수정 창으로 이동!";
			loc="/member/mypageUpdateView.do";
		}else {
			msg="비밀번호가 틀렸습니다!";
			loc="/member/mypage.do";
		}
		model.addAttribute("msg", msg);
		model.addAttribute("loc", loc);
		
		
		return "common/msg";
	}
	
	@RequestMapping("/member/mypageUpdateView.do")
	public String meberUpdateView() {
		
		return "/member/mypageUpdate";
	}
	
	@RequestMapping("/member/mypage.do")
	public String memberUpdateMenu() {
		
		return "/member/mypage";
	}
	
	@RequestMapping("member/mypageDeleteView.do")
	public String memberDeleteView() {
		return "/member/mypageDelete";
	}
	@RequestMapping("/member/gotoIdFind.do")
	public String gotoIdFind() {
		return "member/idFind";
	}
	
	@RequestMapping("/member/idFind.do")
	public String idFindView(HttpServletRequest request, Model model) throws Exception {
		String email = request.getParameter("emailFind");
		
		String msg = emailService.sendEmail(email);
		String loc = "/";
		
		model.addAttribute("msg", msg);
		model.addAttribute("loc", loc);
		
		return "common/msg";
	}
	
	
	@RequestMapping("/member/gotoPwFind.do")
	public String gotoPwFind() {
		return "member/pwFind";
	}
	
	@RequestMapping("/member/pwFind.do")
	public String pwFindView(HttpServletRequest request, Model model) throws Exception {
		String pwFind1 = request.getParameter("pwFind1");
		String pwFind2 = request.getParameter("pwFind2");
		System.out.println(pwFind1);
		System.out.println(pwFind2);
		Member m = new Member();
		m.setUserId(pwFind1);
		m.setEmail(pwFind2);
		int result = emailService.userConfirm(m);
		String msg = "";
		String loc = "";
		if(result ==0) {
			msg = "존재하지 않는 회원입니다";
			loc = "/member/gotoPwFind.do";
		} else {

			RandomNumber rn = new RandomNumber();
			String originPw = rn.getKey(10, true);
			String bcryptPwd = bcryptPasswordEncoder.encode(originPw);
			m.setUserPwd(bcryptPwd);
			
			int resetResult=memberService.resetPw(m);
			if(resetResult>0){
				msg = emailService.sendEmail(pwFind2,originPw);
			}else {
				msg = "비밀번호 변경에 실패했습니다. 계속 안되면 관리자에게 문의해주세요.";
			}
			loc = "/";
		}
	
		
		
		model.addAttribute("msg", msg);
		model.addAttribute("loc", loc);
		
		return "common/msg";
	}
	

}