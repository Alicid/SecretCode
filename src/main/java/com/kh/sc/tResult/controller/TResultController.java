package com.kh.sc.tResult.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.sc.member.model.vo.Member;
import com.kh.sc.tResult.model.service.TResultService;

@Controller
public class TResultController {

	@Autowired TResultService trs;
	
	@RequestMapping("/tResult/selectList.re")
	@ResponseBody
	public int[] selectListTResult(@RequestParam(value="years")int years) {
		
		System.out.println("연도"+years);
		int[] array =trs.tresultList(years);
		
		System.out.println("내용"+array);
		return array;
	}
	
	@RequestMapping("/tResult/selectYears.re")
	@ResponseBody
	public List<Integer> selectYears(){
		System.out.println("연도 리스트 확인 : "+trs.selectYears());
		return trs.selectYears();
	}
	
	@RequestMapping("/tResult/getCategoryAndGo.do")
	public String getCategoryAndGo(Model model) {

		List<HashMap<String,String>> list = trs.getCategoryAndGo();
		//System.out.println(list);
		
		model.addAttribute("category", list);
		return "/member/myStatics";
	}
	
	@RequestMapping("/tResult/selectMyStaticsList.re")
	@ResponseBody
	public int[] selectMyStaticsList(@RequestParam(value="category")int category, HttpSession session) {
		
		System.out.println("카테고리 : " + category);
		
		Map<String, Integer> map = new HashMap<>();
		Member m = (Member) session.getAttribute("member");
		
		map.put("category", category);
		map.put("uNo", m.getuNo());
		int[] array =trs.selectMyStaticsList(map);
		
		System.out.println("내용 : "+array);
		return array;
	}
	
}