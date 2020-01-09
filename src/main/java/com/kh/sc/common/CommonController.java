package com.kh.sc.common;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommonController {

	// 단순 페이지 이동 전용 컨트롤러
	@RequestMapping("/common/pageMove.do")
	public String goPage(@RequestParam(value="uri", required=false) String uri,Model model) {
		System.out.println("주소 왔나요" + uri);
		
		String loc = uri;
		
		model.addAttribute("loc",loc);
		
		
		return "common/pageMove";
	}
	
}
