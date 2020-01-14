package com.kh.sc.tResult.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		
		int[] array =trs.tresultList(years);
		
		return trs.tresultList(years);
	}
}
