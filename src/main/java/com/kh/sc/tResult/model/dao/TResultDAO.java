package com.kh.sc.tResult.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.sc.tResult.model.vo.Qunit;
import com.kh.sc.tResult.model.vo.tResult;

@Repository("trdao")
public class TResultDAO {

	@Autowired
	SqlSessionTemplate sqlSession;
	
	public tResult selectList(int years) {
		return sqlSession.selectOne("tresult-mapper.selectTresult" , years);
	}

	public List<Integer> selectYears() {
		return sqlSession.selectList("tresult-mapper.selectYears");
	}

	public List<HashMap<String, String>> getCategoryAndGo() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("tresult-mapper.getCategoryAndGo");
	}

	public List<Qunit> selectMyStaticsList(Map<String, Integer> map) {
		
		return sqlSession.selectList("tresult-mapper.selectMyStaticsList" , map);
	}
 
	
}
