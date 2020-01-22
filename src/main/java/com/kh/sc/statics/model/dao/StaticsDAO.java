package com.kh.sc.statics.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.sc.statics.model.vo.QuestionStatics;

@Repository
public class StaticsDAO {

	@Autowired
	SqlSessionTemplate sql;
	
	public int insertResult(List<QuestionStatics> list) {
		
		int results = 0;
		for(QuestionStatics qs : list) {
			int result = sql.insert("statics-mapper.insertResult", qs);
			results += result;
		}
		return results;
	}

	public int insertHighScore(Map<String, Object> highScore) {
		return sql.insert("statics-mapper.insertHighScore",highScore);
	}

}
