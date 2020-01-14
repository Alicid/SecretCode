package com.kh.sc.tResult.model.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("trdao")
public class TResultDAO {

	@Autowired
	SqlSessionTemplate sqlSession;
	
	public List<HashMap<String, String>> selectList(int years) {

		return sqlSession.selectList("tresult-mapper.selectTresult" , years);
	}

}
