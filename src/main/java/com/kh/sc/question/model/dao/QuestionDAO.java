package com.kh.sc.question.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QuestionDAO {

		@Autowired
		SqlSessionTemplate sql;
		
		
		
	
}
