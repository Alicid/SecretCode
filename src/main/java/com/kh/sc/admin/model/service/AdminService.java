package com.kh.sc.admin.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.sc.common.PageInfo;
import com.kh.sc.question.model.vo.Answer;
import com.kh.sc.member.model.vo.Member;
import com.kh.sc.admin.model.dao.AdminDAO;
import com.kh.sc.admin.model.vo.Question;
import com.kh.sc.admin.model.vo.Qunit;

@Service
public class AdminService {
	
	@Autowired
	AdminDAO qdao;
	
	/*
	 * public int insertQuestion(Question question) { int result = 0;
	 * 
	 * result = qdao.insertQuestion(question); if(result < 1) throw new
	 * QuestionException("글 작성 중 에러 발생");
	 * 
	 * return result;
	 * 
	 * }
	 */
	
	public List<Question> selectList(HashMap<String, Object> map) {
		return qdao.selectList(map);
		
	}
	
	public Question selectOne(int qNo) {
		
		
		Question q = new Question();
			q = qdao.selectOne(qNo);
		
		
		return q;
		
	}

	public int getListCount() {
		return qdao.getListCount();
	}
//
//	public int updateQuestion(Question originQuestion) {
//		int result = 0;
//		
//		result = qdao.updateQuestion(originQuestion);
//		
//		if(result < 1) throw new QuestionException("게시글 수정 중 에러 발생");
//		
//		return result;
//	}
//
//	public int deleteQuestion(int qNo) {
//		return qdao.deleteQuestion(qNo);
//	}

	public List<HashMap<String, String>> selectCategoryList() {
		return qdao.selectCategoryList();
	}

	public int getsListCount(HashMap<String, Object> map) {
		return qdao.getsListCount(map);
	}
/*
	public List<Question> SearchSelectList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return qdao.SearchSelectList(map);
	}
*/
	public List<HashMap<String, String>> searchList(HashMap<String, Object> map) {
		
		return qdao.searchList(map);
	}
	public int insertQuestions(List<List<Object>> list) {
		return qdao.insertQuestions(list);
	}

	public Question updateQuestionView(int qNo) {
		return qdao.updateQuestionView(qNo);
	}

	public int updateQuestion(Question q) {
		return qdao.updateQuestion(q);
	}
	public List<Member> selectadminMemberList() {
		return qdao.selectadminMemberList();
	}

	public int adminMemberUpdate(Member m) {
		return qdao.adminMemberUpdate(m);
	}

	public List<Answer> selectCorrectAnswers(int qNo) {
		return qdao.selectCorrectAnswer(qNo);
	}

	public List<Answer> selectWrongAnswers(int qNo) {
		// TODO Auto-generated method stub
		return qdao.selectWrongAnswer(qNo);
	}

	

	

}
