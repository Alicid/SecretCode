package com.kh.sc.Question.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kh.sc.Question.model.service.QuestionService;
import com.kh.sc.member.model.vo.Member;

@Controller
public class QuestionController {

	@Autowired
	QuestionService qs;
	
	@RequestMapping("/question/getCategory.do")
	public String selectCategory(Model model) {
		
		List<HashMap<String,String>> list = qs.selectCategoryList();
		//System.out.println(list);
		
		model.addAttribute("category", list);
		
		return "question/CategorySelect";
	}
	
	@RequestMapping("/question/questionSelectList.do")
	public String goQuestionPage(@RequestParam String category,@RequestParam String mode,@RequestParam int unit, Model model) {
		
		System.out.println("카테고리 번호 : "+category); 
		System.out.println("단원선택 확인 : " + unit);
		int categoryNum = Integer.parseInt(category);
		System.out.println(categoryNum);
		System.out.println(mode);
		
		Map<String,Object> map = new HashMap();
		
		map.put("categoryNum", categoryNum);
		map.put("unit", unit);
		
		Map<String,String> categoryName = qs.selectCategoryName(map);
		
		if(unit==0) {
			categoryName.put("un", "전체");
			categoryName.put("unum", "0");
		}
		
		System.out.println(categoryName);
		//List<HashMap<String,String>> list = qs.selectUnitName();
		model.addAttribute("category", categoryName).addAttribute("mode", mode).addAttribute("categoryNum",categoryNum);
		
		
		return "question/QuestionView";
	}
	
	@RequestMapping("/question/printResult.do")
	public String printResult(HttpSession session,Model model) {
		
		Map<String,Object> map = (Map<String, Object>) session.getAttribute("result");
		System.out.println("화면 전달 확인 : "+map);
		System.out.println(map.get("Q1"));
		Member m = (Member) session.getAttribute("member");
		
		m.getuNo();
		
		model.addAttribute("result", map);
		
		
		return "question/questionScore";
	}
	
}
