package com.kh.sc.Question.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.sc.Question.model.dao.QuestionDAO;
import com.kh.sc.Question.model.vo.Questions;

@Service
public class QuestionService {

	@Autowired
	QuestionDAO qdao;
	
	public Questions selectOneQuestion(Map<String, Integer> cMap) {
		return qdao.selectOneQuestion(cMap);
	}

	public List<HashMap<String,String>> selectCategoryList() {
		
		return qdao.selectCategoryList();
	}

	public Map selectCategoryName(Map<String, Object> map) {
		return qdao.selectCategoryName(map);
	}

	public List<HashMap<String,String>> selectUnitNum(int category) {
		return qdao.selectUnitNum(category);
	}

//	public List<HashMap<String, String>> selectUnitName() {
//		return qdao.selectUnitName();
//	}



}
