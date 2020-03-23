package com.kh.sc.question.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.sc.question.model.dao.QuestionDAO;
import com.kh.sc.question.model.vo.Questions;
import com.kh.sc.statics.model.vo.QuestionStatics;

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

	public List selectHighScore() {
		return qdao.selectHighScore();
	}

	public List<Questions> getQuestionList(TreeMap<String, String> tmap) {
		return qdao.getQuestionList(tmap);
	}

//	public List<HashMap<String, String>> selectUnitName() {
//		return qdao.selectUnitName();
//	}



}
