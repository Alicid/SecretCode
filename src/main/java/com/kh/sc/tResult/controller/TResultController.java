package com.kh.sc.tResult.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
