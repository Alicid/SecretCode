package com.kh.sc.admin.model.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.sc.common.PageInfo;
import com.kh.sc.member.model.vo.Member;
import com.kh.sc.question.model.vo.Answer;
import com.kh.sc.admin.model.vo.AnswerInsert;
import com.kh.sc.admin.model.vo.Question;
import com.kh.sc.admin.model.vo.QuestionInsert;
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
	public List<Member> selectadminMemberList() {
		return sqlSession.selectList("member-mapper.selectMemberList");
	}


	public int adminMemberUpdate(Member m) {
		return sqlSession.update("member-mapper.adminMemberUpdate",m);
	}
	
	
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
	public int insertQuestions(List<List<Object>> list) {
		int num=0;
		int result=0;
		for(int i=0;i<list.size();i++) {
			for(int j=0;j<list.get(i).size();j++) {
				if(j==0) {
					QuestionInsert qin = (QuestionInsert) list.get(i).get(j);
					result += sqlSession.insert("question-mapper.insertQuestion",qin);
				}else {
					AnswerInsert ain = (AnswerInsert) list.get(i).get(j);
					//ain.setQno(num);
					result += sqlSession.insert("question-mapper.insertAnswer",ain);
				}
			}
		}
		
		
		return result;
	}


	public List<Answer> selectCorrectAnswer(int qNo) {
		return sqlSession.selectList("question-mapper.selectCorrectAnswer",qNo);
	}


	public List<Answer> selectWrongAnswer(int qNo) {
		return sqlSession.selectList("question-mapper.selectWrongAnswer",qNo);
	}


	public Question updateQuestionView(int qNo) {
		return sqlSession.selectOne("question-mapper.updateQuestionView",qNo);
	}


	public int updateQuestion(Question q) {
		return sqlSession.update("question-mapper.updateQuestion",q);
	}

}
