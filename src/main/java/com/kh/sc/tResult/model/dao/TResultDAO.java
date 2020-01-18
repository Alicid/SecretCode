package com.kh.sc.tResult.model.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

}
