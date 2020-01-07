package com.kh.sc.member.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@RequestMapping("/member/checkIdDuplicate.do")
	@ResponseBody
	public Map<String, Object> checkIdDuplicate(@RequestParam String userId) {
		System.out.println("전달 확인 : "+userId);
		boolean isUsable = memberService.checkIdDuplicate(userId) == 0 ? true : false;
		System.out.println("isUsable" + isUsable);
		Map<String, Object> map = new HashMap<>();
		map.put("isUsable", isUsable);
		
		return map;
	}

}














