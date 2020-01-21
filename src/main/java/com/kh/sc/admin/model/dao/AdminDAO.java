package com.kh.sc.admin.model.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.sc.common.PageInfo;
import com.kh.sc.admin.model.vo.Question;
import com.kh.sc.admin.model.vo.Qunit;

@Repository("qdao")
public class AdminDAO {
	
	@Autowired
	SqlSessionTemplate sqlSession;

	/*
	 * public int insertQuestion(Question question) { return
	 * sqlSession.insert("question-mapper.insertQuestion", question); }
	 */

	public List<Question> selectList(PageInfo pi) {
		return sqlSession.selectList("question-mapper.selectQuestion", pi);
	}


	public Question selectOne(int qNo) {
		return sqlSession.selectOne("question-mapper.selectDetail", qNo);
	}

	public int getListCount() {
		return sqlSession.selectOne("question-mapper.getListCount");
	}
//
//	public int updateQuestion(Question originQuestion) {
//		return sqlSession.update("question-mapper.updateQuestion", originQuestion);
//	}
//
//	public int deleteQuestion(int qNo) {
//		return sqlSession.update("question-mapper.deleteNotice", qNo);
//	}


	public List<HashMap<String, String>> selectQunit() {
		return sqlSession.selectList("qunit-mapper.selectQunit");
	}


	public List<HashMap<String, String>> selectCategoryList() {
		return sqlSession.selectList("question-mapper.selectCategoryList");
	}

}
