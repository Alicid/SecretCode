package com.kh.sc.admin.model.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.sc.common.PageInfo;
import com.kh.sc.admin.model.vo.Question;

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

	public List<HashMap<String, String>> selectCategoryList() {
		return sqlSession.selectList("question-mapper.selectCategoryList");
	}


	public int getsListCount(HashMap<String, Object> map) {
		return sqlSession.selectOne("question-mapper.getsListCount", map);
	}
	
	public List<HashMap<String, String>> searchList(HashMap<String, Object> map) {
		System.out.println(map);
		return sqlSession.selectList("question-mapper.SearchSelectList", map);
	}

}
