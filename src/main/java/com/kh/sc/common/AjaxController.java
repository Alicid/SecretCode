package com.kh.sc.common;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.sc.member.model.service.MemberService;

// Ajax기능 전용 컨트롤러
@RestController
public class AjaxController {

	@Autowired
	MemberService memberService;
	
	@RequestMapping("/member/checkIdDuplicate.do")
	public  Map<String, Object> idDupCheck(@RequestParam String userId) {
		
		boolean isUsable = memberService.checkIdDuplicate(userId)== 0? true:false;
		Map map = new HashMap();
		//map.put("isUsable",isUsable);
		System.out.println(map);
		return map;
	}
	
	
}
