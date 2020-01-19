package com.kh.sc.statics.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.sc.statics.model.dao.StaticsDAO;
import com.kh.sc.statics.model.vo.QuestionStatics;

@Service
public class StaticsService {

	@Autowired
	StaticsDAO sdao;
	
	public int insertResult(List<QuestionStatics> list) {
		return sdao.insertResult(list);
	}

	public int insertHighScore(Map<String, Object> highScore) {
		return sdao.insertHighScore(highScore);
	}

}
