package com.kh.sc.admin.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.sc.common.PageInfo;
import com.kh.sc.member.model.vo.Member;
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


	public List<Member> selectadminMemberList() {
		return sqlSession.selectList("member-mapper.selectMemberList");
	}


	public int adminMemberUpdate(Member m) {
		return sqlSession.update("member-mapper.adminMemberUpdate",m);
	}

}
